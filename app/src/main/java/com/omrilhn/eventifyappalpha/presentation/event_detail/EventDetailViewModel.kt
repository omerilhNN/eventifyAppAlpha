package com.omrilhn.eventifyappalpha.presentation.event_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.omrilhn.eventifyappalpha.domain.use_cases.EventCardUseCases
import javax.inject.Inject

class EventDetailViewModel @Inject constructor(
//    private val authenticate: AuthenticateUseCase,
    private val eventCardUseCases: EventCardUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(EventDetailState())
    val state: State<EventDetailState> = _state

}