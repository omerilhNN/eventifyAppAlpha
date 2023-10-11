package com.omrilhn.eventifyappalpha.presentation.main_feed

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.core.domain.models.EventsItem
import com.omrilhn.eventifyappalpha.core.presentation.components.EventCard
import com.omrilhn.eventifyappalpha.data.DataOrException

@Composable
fun TestScreen(
    navController: NavController,
    viewModel: MainFeedViewModel = hiltViewModel()
    ){
    val data: DataOrException<ArrayList<EventsItem>, Boolean, Exception> by viewModel.data
    val events = viewModel.data.value.data?.toMutableList()
//
//    LaunchedEffect(Unit){ FETCH EVENTS SİLİNMEDEN ÖNCE
//            viewModel.fetchEvents()
//    }
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn {
            if (data.loading == true) {
                if (events != null) {
                    items(events.size){ item ->
                        EventCard(data = events[item]) {
                            Log.d("TAG","EVENT CARD HAS BEEN CLICKED")

                        }
                    }
                }
            }
    }

}
    }
