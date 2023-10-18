package com.omrilhn.eventifyappalpha.presentation.main_feed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omrilhn.eventifyappalpha.core.domain.models.EventResponse
import com.omrilhn.eventifyappalpha.core.domain.models.EventsItem
import com.omrilhn.eventifyappalpha.domain.use_cases.EventCardUseCases
import com.omrilhn.eventifyappalpha.core.domain.repository.EventRepository
import com.omrilhn.eventifyappalpha.data.DataOrException
import com.omrilhn.eventifyappalpha.presentation.components.PagingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val eventCardUseCases: EventCardUseCases,
    private val eventRepository:EventRepository

) : ViewModel() {

//    private val _events = MutableStateFlow(emptyList<EventModel>())
//    val events : StateFlow<List<EventModel>> get() = _events
     val data: MutableState<DataOrException<EventResponse,
        Boolean,Exception>> = mutableStateOf(
            DataOrException(null,true,Exception("")))
    init{
        getAllEvents()
    }

    var errorMessage: String by mutableStateOf("")

    //For SearchBar
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

//    private val _eventFlow = MutableSharedFlow<Event>()
//    val eventFlow = _eventFlow.asSharedFlow()

    private val _pagingState = mutableStateOf<PagingState<EventResponse>>(PagingState())
    val pagingState: State<PagingState<EventResponse>> = _pagingState

    private fun getAllEvents(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = eventRepository.getEvents()
            if(data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }



//    private val paginator = DefaultPaginator(
//        onLoadUpdated = { isLoading ->
//            _pagingState.value = pagingState.value.copy(
//                isLoading = isLoading
//            )
//        },
//        onRequest = { page ->
//            eventCardUseCases.getPostsForFollows(page = page)
//        },
//        onSuccess = { events ->
//            _pagingState.value = pagingState.value.copy(
//                items = pagingState.value.items + events,
//                endReached = events.isEmpty(),
//                isLoading = false
//            )
//        },
//        onError = { uiText ->
//            _eventFlow.emit(UiEvent.ShowSnackbar(uiText))
//        }

//    suspend fun fetchEvents(){
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = eventRepo.getEvents()
//                if(response.isSuccessful){
//                    Log.d("TAG","Response is Successful")
//                    _events.value = response.body()!!
//                }
//
//            }catch (_:Exception){
//
//            }
//
//        }
//    }





    fun loadNextPosts() {
//        viewModelScope.launch {
//            paginator.loadNextItems()
//        }
    }
    //SearchBar function
    fun setSearchText(searchText:String){
        _searchText.value = searchText
    }
}