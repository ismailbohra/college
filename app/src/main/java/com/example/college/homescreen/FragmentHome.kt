package com.example.college.homescreen

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.college.Adapters.HorizontalrecyclerViewAdapter
import com.example.college.Adapters.recyclerViewAdapter
import com.example.college.R
import com.example.college.dataClass.HorizontalRecyclerViewdata
import com.example.college.dataClass.RecyclerViewdata
import com.example.college.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var category:Array<String>
    private lateinit var arrayList:ArrayList<HorizontalRecyclerViewdata>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        category= arrayOf("Sports","Singing","Dance","Robotics","choirs","Anchoring")

        binding.horizontalRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.horizontalRecyclerView.setHasFixedSize(true)

        arrayList = arrayListOf<HorizontalRecyclerViewdata>()
        getData()

        return binding.root
    }
    private fun getData() {
        for (i in category.indices){
            val data = HorizontalRecyclerViewdata(category[i])
            arrayList.add(data)
        }
        binding.horizontalRecyclerView.adapter = HorizontalrecyclerViewAdapter(arrayList)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }


}