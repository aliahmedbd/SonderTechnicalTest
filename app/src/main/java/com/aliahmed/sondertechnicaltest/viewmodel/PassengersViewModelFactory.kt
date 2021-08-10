package com.aliahmed.sondertechnicaltest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliahmed.sondertechnicaltest.network.APIInterface

@Suppress("UNCHECKED_CAST")
class PassengersViewModelFactory(
    private val api: APIInterface
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PassengersViewModel(api) as T
    }
}