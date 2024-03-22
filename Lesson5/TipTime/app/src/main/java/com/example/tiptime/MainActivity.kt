package com.example.tiptime

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calcButton: Button = binding.calculateButton

        calcButton.setOnClickListener{
            calculateTip()
        }

    }
    private fun calculateTip(){
        val input = binding.billInput.text.toString()
        val cost = input.toDouble()

        val tipPercentage = when (binding.serviceQualityGroup.checkedRadioButtonId) {
            R.id.twenty -> 0.20
            R.id.fifteen -> 0.15
            else -> 0.10
        }

        var tip = tipPercentage * cost

        val roundUp = binding.roundUpSwitch.isChecked

        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }

        binding.tipTotal.text = "Tip Ammount is $" + tip
    }
}
