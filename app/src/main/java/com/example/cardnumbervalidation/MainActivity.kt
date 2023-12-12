package com.example.cardnumbervalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun validate (number:String) :Boolean {
            val numbers = number.filter { it.isDigit() }.reversed()
            var sum: Int = 0
            val parity: Int = numbers.length % 2

            for (i in numbers.indices) {
                var digit = numbers[i].digitToInt()

                if ( (i+1) % 2 == parity ) {
                    digit *= 2
                    if (digit > 9) digit -= 9
                }

                sum += digit
            }

            return sum % 10 == 0
        }

        val cardNumber: EditText = findViewById(R.id.cardNumber)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val cardNumber = cardNumber.text.toString()

            if (validate(cardNumber))
                Toast.makeText(this, "Correct card number", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Incorrect card number", Toast.LENGTH_SHORT).show()
        }
    }
}