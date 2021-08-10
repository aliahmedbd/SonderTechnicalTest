package com.aliahmed.sondertechnicaltest.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.model.PassengerBaseResponse
import com.aliahmed.sondertechnicaltest.network.APIInterface
import com.aliahmed.sondertechnicaltest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PassengerListRepository( private val api: APIInterface):  PagingSource<Int, Passenger>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Passenger> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = api.getPassengerList(nextPageNumber)
            PagingSource.LoadResult.Page(
                data = response.data,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.totalPages) nextPageNumber + 1 else null
            )

        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        TODO("Not yet implemented")
    }
}