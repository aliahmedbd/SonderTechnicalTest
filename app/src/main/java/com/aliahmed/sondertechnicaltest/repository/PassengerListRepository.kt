package com.aliahmed.sondertechnicaltest.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.network.APIInterface
import retrofit2.HttpException
import java.io.IOException

class PassengerListRepository(private val api: APIInterface) : PagingSource<Int, Passenger>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Passenger> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = api.getPassengerList(nextPageNumber)
            PagingSource.LoadResult.Page(
                data = response.data,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.totalPages) nextPageNumber + 1 else null
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        TODO("Not yet implemented")
    }
}