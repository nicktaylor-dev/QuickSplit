package com.application.quicksplit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.application.quicksplit.R
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val billEditText = findViewById<EditText>(R.id.billText)
        val calculatebutton = findViewById<Button>(R.id.calculateButton)

        calculatebutton.setOnClickListener {
            val billInput = billEditText.text.toString()
            val billAmount = billInput.toDoubleOrNull()

            if (billAmount == null) {
                Toast.makeText(this, "Invalid bill amount", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Bill amount: $billAmount", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}