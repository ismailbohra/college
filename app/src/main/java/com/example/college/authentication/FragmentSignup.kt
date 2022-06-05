package com.example.college.authentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.college.MainActivity
import com.example.college.R
import com.example.college.databinding.FragmentSignupBinding
import com.example.college.homescreen.Credentials
import com.example.college.homescreen.HomeScreen
import com.example.college.homescreen.User

class FragmentSignup : Fragment() {
    lateinit var binding: FragmentSignupBinding
    companion object{
        const val LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val savedInstanceState = findNavController().previousBackStackEntry!!.savedStateHandle
        savedInstanceState.set(LOGIN_SUCCESSFUL,false)


        binding = FragmentSignupBinding.inflate(layoutInflater,container,false)

        binding.btnSignIn.setOnClickListener {
            val username = binding.userUsername.text.toString()
            val password = binding.userPassword.text.toString()

            Credentials.user = User(username,password)
            savedInstanceState.set(LOGIN_SUCCESSFUL,true)

            val intent = Intent(requireContext(), HomeScreen::class.java)
            startActivity(intent)
            requireActivity().finish()
        }


        return binding.root
    }
}