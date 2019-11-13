package com.example.philcororetro.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.philcororetro.local.ActionDao
import com.example.philcororetro.model.Action
import com.example.philcororetro.model.ViewState
import com.example.philcororetro.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActionsRepository  @Inject constructor(
    private val actionDao: ActionDao,
    private val actionService: RetrofitService
) {


    fun getActions(): Flow<ViewState<List<Action>>> {
        return flow {
            // 1. Start with loading + data from database
            emit(ViewState.success(actionDao.getActions()))

            // 2. Try fetching new news -> save + emit
            val actionsSource = actionService.getActions()
            actionDao.insertActions(actionsSource.actions)

            // 3. Get articles from database [Single source of truth]
            emit(ViewState.success(actionDao.getActions()))


        }.catch {
            //println("Error!")

            emit(ViewState.error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }

}