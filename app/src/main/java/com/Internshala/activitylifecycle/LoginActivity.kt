package com.Internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){
    lateinit var etPhone:EditText
    lateinit var etPass:EditText
    lateinit var btnLogIn:Button
    lateinit var txtForgotPass:TextView
    lateinit var txtRegister:TextView
    private val mobileNum = "7011584132"
    lateinit var passArray:Array<String>
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false);
        setContentView(R.layout.activity_login)
        if(isLoggedIn)
        {
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"
        etPhone = findViewById(R.id.etPhone)
        etPass = findViewById(R.id.etPass)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgotPass = findViewById(R.id.txtForgotPass)
        txtRegister = findViewById(R.id.txtRegister)
        passArray = arrayOf("tony","steve","bruce","thanos")
        btnLogIn.setOnClickListener {
            var nameOfAvenger:String
            val enteredMob = etPhone.text.toString();
            val enteredPass = etPass.text.toString()
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            if(enteredMob.equals(mobileNum))
            {
                if(enteredPass==passArray[0])
                {
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(enteredPass == passArray[1]){
                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(enteredPass == passArray[2]){
                    nameOfAvenger = "The Hulk"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(enteredPass == passArray[3]){
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this@LoginActivity,"Wrong Password",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
            Toast.makeText(this@LoginActivity,"Wrong Mobile Number",Toast.LENGTH_LONG).show();
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String)
    {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}