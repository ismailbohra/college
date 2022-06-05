package com.example.college.homescreen

class Credentials(){
    companion object{
        var user:User?=null
    }
}
data class User(val username:String,val password:String)