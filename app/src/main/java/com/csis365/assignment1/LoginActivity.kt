package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var btnProceed: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private val keyUsername = "key_username"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnProceed = findViewById(R.id.btn_proceed)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        val prefs: SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(keyUsername, "skarni").commit()

        btnProceed.setOnClickListener {
            Log.d("asdf","Button has been pressed")
            Log.i("asdf", "Username is " + etUsername.text.toString())
            Log.v("asdf", "Password is ${etPassword.text}")

            if(etUsername.text.length >= 4 && etPassword.text.toString() == ("password")) {
                Toast.makeText(getApplicationContext(),
                    "Login Successful",Toast.LENGTH_SHORT).show()

                Log.d("asdf","Got in if statement")
                val intent = Intent(this, FruitListActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(getApplicationContext(),
                    "Login Failed",Toast.LENGTH_SHORT).show()
            }
        }

        val prefs2: SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val userName = prefs2.getString(keyUsername, "default value")

        Log.d("asdf", userName.toString())
    }
}