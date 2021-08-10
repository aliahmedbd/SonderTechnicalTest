package com.aliahmed.sondertechnicaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aliahmed.sondertechnicaltest.R
import com.aliahmed.sondertechnicaltest.databinding.ActivityMainBinding
import com.aliahmed.sondertechnicaltest.databinding.ActivityPassengerDetailsBinding
import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.utils.ConstantValue
import com.aliahmed.sondertechnicaltest.utils.loadImage
import com.google.gson.Gson

class PassengerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPassengerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassengerDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initialize()
    }

    private fun initialize(){
        val passenger = Gson().fromJson(intent?.extras?.getString(ConstantValue.passengerData), Passenger::class.java)
        binding.imgLogo.loadImage(passenger.airline[0].logo)
        binding.txtCountyName.text = "Country: ${passenger.airline[0].name}"
        binding.txtFlightName.text = passenger.airline[0].name
        binding.txtPassengerName.text ="Passenger: ${passenger.name}"
        binding.txtTrips.text ="Trips: ${passenger.trips}"
    }

}