package com.omrilhn.eventifyappalpha.presentation.main_feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omrilhn.eventifyappalpha.domain.use_cases.EventCardUseCases
import com.omrilhn.eventifyappalpha.presentation.components.EventList
import com.omrilhn.eventifyappalpha.presentation.components.PagingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val eventCardUseCases: EventCardUseCases

) : ViewModel() {
    //For SearchBar
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _events = MutableStateFlow(listOf<EventList>())
    val events = searchText. //whenever our searchText or events changes then combine it with
        combine(_events){text,events->

        }

    //-----
    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _pagingState = mutableStateOf<PagingState<Post>>(PagingState())
    val pagingState: State<PagingState<Post>> = _pagingState

    private val paginator = DefaultPaginator(
        onLoadUpdated = { isLoading ->
            _pagingState.value = pagingState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            eventCardUseCases.getPostsForFollows(page = page)
        },
        onSuccess = { posts ->
            _pagingState.value = pagingState.value.copy(
                items = pagingState.value.items + posts,
                endReached = posts.isEmpty(),
                isLoading = false
            )
        },
        onError = { uiText ->
            _eventFlow.emit(UiEvent.ShowSnackbar(uiText))
        }
    )

    init {
        loadNextPosts()
    }
    fun loadNextPosts() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }
    //SearchBar function
    fun onSearchTextChange(searchText:String){
        _searchText.value = searchText
    }
}