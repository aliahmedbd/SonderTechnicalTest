package com.aliahmed.sondertechnicaltest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.aliahmed.sondertechnicaltest.network.APIInterface
import com.aliahmed.sondertechnicaltest.repository.PassengerListRepository

class PassengersViewModel(
    private val api: APIInterface
) : ViewModel() {
    val passengers = Pager(PagingConfig(pageSize = 10)) {
        PassengerListRepository(api)
    }.flow.cachedIn(viewModelScope)
}