package com.amontes.neotest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amontes.neotest.R
import com.amontes.neotest.helpers.OPTTextWatcher
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = arrayOf<EditText>(otp_edit_box1, otp_edit_box2, otp_edit_box3, otp_edit_box4, otp_edit_box5, otp_edit_box6)

        otp_edit_box1.addTextChangedListener(OPTTextWatcher(otp_edit_box1, edit))
        otp_edit_box2.addTextChangedListener(OPTTextWatcher(otp_edit_box2, edit))
        otp_edit_box3.addTextChangedListener(OPTTextWatcher(otp_edit_box3, edit))
        otp_edit_box4.addTextChangedListener(OPTTextWatcher(otp_edit_box4, edit))
        otp_edit_box5.addTextChangedListener(OPTTextWatcher(otp_edit_box5, edit))
        otp_edit_box6.addTextChangedListener(OPTTextWatcher(otp_edit_box6, edit))

        btnLogIn.setOnClickListener {
            if (fieldsCompleted()) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Favor de completar la contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fieldsCompleted() : Boolean {
        var completed = true

        if (otp_edit_box1.text.toString().trim() == "")
            completed = false

        if (otp_edit_box2.text.toString().trim() == "")
            completed = false

        if (otp_edit_box3.text.toString().trim() == "")
            completed = false

        if (otp_edit_box4.text.toString().trim() == "")
            completed = false

        if (otp_edit_box5.text.toString().trim() == "")
            completed = false

        if (otp_edit_box6.text.toString().trim() == "")
            completed = false

        return completed
    }
}