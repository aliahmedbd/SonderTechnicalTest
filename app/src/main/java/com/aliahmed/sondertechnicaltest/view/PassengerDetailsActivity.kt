package com.aliahmed.sondertechnicaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aliahmed.sondertechnicaltest.R
import com.aliahmed.sondertechnicaltest.databinding.ActivityMainBinding
import com.aliahmed.sondertechnicaltest.databinding.ActivityPassengerDetailsBinding

class PassengerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPassengerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassengerDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}