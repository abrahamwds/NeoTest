package com.amontes.neotest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amontes.neotest.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnConfirm.setOnClickListener {
            if (fieldsCompleted())
                Toast.makeText(this, "Monto: ${edtAmount.text}\nCosto: ${edtCost.text}\nTotal: ${edtTotal.text}", Toast.LENGTH_LONG).show()

        }
    }

    private fun fieldsCompleted() : Boolean {
        var completed = true

        if (edtAmount.text.toString().trim() == "") {
            completed = false
            lyAmount.error = "Completa este campo"
        } else {
            lyAmount.error = null
        }

        if (edtCost.text.toString().trim() == "") {
            completed = false
            lyCost.error = "Completa este campo"
        } else {
            lyCost.error = null
        }

        if (edtTotal.text.toString().trim() == "") {
            completed = false
            lyTotal.error = "Completa este campo"
        } else {
            lyTotal.error = null
        }

        return completed
    }
}