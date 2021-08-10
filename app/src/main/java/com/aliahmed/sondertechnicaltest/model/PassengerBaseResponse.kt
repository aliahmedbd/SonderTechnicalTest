package com.aliahmed.sondertechnicaltest.model

data class PassengerBaseResponse(
	val `data`: List<Passenger>,
	val totalPages: Int,
	val totalPassengers: Int
)