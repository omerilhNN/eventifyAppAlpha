package com.omrilhn.eventifyappalpha.presentation.personal_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonalDetailViewModel @Inject constructor(): ViewModel() {
    private val _eventTypesFlow = MutableSharedFlow<List<String>>()
    val eventTypesFlow = _eventTypesFlow.asSharedFlow()

    private val _musicGenreFlow = MutableSharedFlow<List<String>>()
    val musicGenreFlow = _musicGenreFlow.asSharedFlow()
    fun updateEventTypes(eventList: List<String>) {
        viewModelScope.launch {
            _eventTypesFlow.tryEmit(eventList)
        }

    }
    fun updateMusicGenre(genreList:List<String>){
        viewModelScope.launch {
            _musicGenreFlow.tryEmit(genreList)
        }
    }
}