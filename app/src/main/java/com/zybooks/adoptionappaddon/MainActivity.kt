package com.zybooks.adoptionappaddon

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ---------- DEMO: Button click listener (one widget) ----------
        val placeOrderButton = findViewById<Button>(R.id.placeOrderButton)

        val listener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Order placed", Toast.LENGTH_LONG).show();

            }

        }

        placeOrderButton.setOnClickListener(listener)

        // ---------- DEMO: Shared click listener for 3 RadioButtons ----------
       setupCoffeeSizeListeners()


    }

    private fun setupCoffeeSizeListeners() {
        val smallRadioButton = findViewById<RadioButton>(R.id.smallRadioButton)
        val mediumRadioButton = findViewById<RadioButton>(R.id.mediumRadioButton)
        val largeRadioButton = findViewById<RadioButton>(R.id.largeRadioButton)

        val sizeClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                when (v?.id) {
                    R.id.smallRadioButton ->
                        Toast.makeText(this@MainActivity, "Small selected", Toast.LENGTH_SHORT).show()

                    R.id.mediumRadioButton -> Toast.makeText(this@MainActivity, "Medium", Toast.LENGTH_LONG)
                        .show()
                    R.id.largeRadioButton -> Toast.makeText(this@MainActivity, "Large", Toast.LENGTH_LONG).show()
                }
            }
        }

        smallRadioButton.setOnClickListener(sizeClickListener)
        mediumRadioButton.setOnClickListener(sizeClickListener)
        largeRadioButton.setOnClickListener(sizeClickListener)
    }
}