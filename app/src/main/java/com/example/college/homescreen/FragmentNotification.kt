package com.example.college.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.college.R
import com.example.college.databinding.FragmentNotificationBinding

class FragmentNotification : Fragment(R.layout.fragment_notification) {
    lateinit var binding: FragmentNotificationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)

        binding.notificationContent.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotification())

        return binding.root
    }

    private fun getNotification(): List<String> {
        val notification = mutableListOf<String>()

        for (i in 1..20){
            notification.add("Notification $i")
        }

        return notification
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }
}