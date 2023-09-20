package com.omrilhn.eventifyappalpha.presentation.event_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.omrilhn.eventifyappalpha.domain.use_cases.EventCardUseCases
import javax.inject.Inject

class EventDetailViewModel @Inject constructor(
//    private val authenticate: AuthenticateUseCase,
    private val eventCardUseCases: EventCardUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

}