package com.aliahmed.sondertechnicaltest.utils

import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.model.PassengerBaseResponse
import java.text.FieldPosition

interface ItemClickListener {
    fun itemClick(position: Passenger)
}