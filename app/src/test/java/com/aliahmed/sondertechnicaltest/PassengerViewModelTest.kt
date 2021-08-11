package com.aliahmed.sondertechnicaltest

import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.network.APIInterface
import com.aliahmed.sondertechnicaltest.repository.PassengerListRepository
import com.aliahmed.sondertechnicaltest.viewmodel.PassengersViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class PassengerViewModelTest {


    @Mock
    lateinit var passenger: Passenger

    @Mock
    lateinit var repository: PassengerListRepository

    @Mock
    lateinit var api: APIInterface

    lateinit var passengersViewModel: PassengersViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = mock(PassengerListRepository::class.java)
        passenger = mock(Passenger::class.java)
        this.passengersViewModel = PassengersViewModel(api)
    }

    @Test
    fun fetchRepositories_API_success() {
        Runnable {
            val listType = object : TypeToken<List<Passenger>>() {}.type
            val passengerList: List<Passenger> = Gson().fromJson(loadJSONFromAssets(), listType)
            Assert.assertNotNull(this.passengersViewModel.passengers)
            Assert.assertEquals(passengerList, this.passengersViewModel.passengers)
            verify(passengersViewModel).passengers
        }
    }

    private fun loadJSONFromAssets(): String? {
        var json: String? = null
        try {
            val classLoader = this.javaClass.classLoader
            val inputStream = classLoader?.getResourceAsStream("mockrepojson.json")
            val size = inputStream?.available()
            val buffer = size?.let { ByteArray(it) }
            inputStream?.read(buffer)
            inputStream?.close()

            json = buffer?.let { String(it, Charsets.UTF_8) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

}