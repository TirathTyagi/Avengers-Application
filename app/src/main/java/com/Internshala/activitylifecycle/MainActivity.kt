package com.Internshala.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() { // AppCompatActivity is a class containing all states and callbacks etc.
    var titleName:String? = "Avengers"
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // super keyword is calling the default function onCreate(). So this is used for default implementation.
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scroll_view)
        if(intent!=null)
        {
            titleName = sharedPreferences.getString("Title","Avengers")
        }
        print(titleName)
        title = titleName
    }
}