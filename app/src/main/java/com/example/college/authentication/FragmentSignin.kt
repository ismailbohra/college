package com.example.college.authentication

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.college.R
import com.example.college.databinding.ActivityMainBinding
import com.example.college.databinding.FragmentSigninBinding
import com.example.college.homescreen.Credentials
import com.example.college.homescreen.HomeScreen
import kotlinx.android.synthetic.main.fragment_signin.*

class FragmentSignin : Fragment() {
    lateinit var binding: FragmentSigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSigninBinding.inflate(layoutInflater,container,false)
        if(Credentials.user==null){
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right).build()

            findNavController().navigate(R.id.fragmentSignup,null,navOptions)
        }
        binding.btnSignIn.setOnClickListener{
            if (binding.etPassword.text.toString()==Credentials.user!!.password && binding.etUsername.text.toString()==Credentials.user!!.username)
            {
                val intent = Intent(requireContext(), HomeScreen::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
            else{
                Toast.makeText(requireContext(),"please enter correct details",Toast.LENGTH_LONG).show()
            }
        }

//        val currentBackStackEntry = findNavController().currentBackStackEntry
//        val savedInstanceState = currentBackStackEntry!!.savedStateHandle
//        savedInstanceState.getLiveData<Boolean>(FragmentSignup.LOGIN_SUCCESSFUL).observe(currentBackStackEntry) {
//            if (!it) {
//                activity?.finish()
//            }
//        }
        return binding.root
    }
}