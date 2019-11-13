package com.example.philcororetro.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.philcororetro.model.Action
import com.example.philcororetro.repo.ActionsRepository
import androidx.lifecycle.asLiveData
import com.example.philcororetro.model.ViewState
import javax.inject.Inject

class ActionViewModel @Inject constructor(
    actionsRepository: ActionsRepository
) : ViewModel() {

    private val actions: LiveData<ViewState<List<Action>>> = actionsRepository.getActions().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getActions(): LiveData<ViewState<List<Action>>> = actions
}