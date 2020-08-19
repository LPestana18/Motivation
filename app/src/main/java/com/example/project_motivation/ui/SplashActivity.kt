package com.example.project_motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.project_motivation.R
import com.example.project_motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null) {
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)

        val securityPreferences = SecurityPreferences(this)
        securityPreferences.storeString("", "")
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if(name != ""){
            mSecurityPreferences.storeString("name", name)

            // de um jeito
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // de outro jeito
//            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
}