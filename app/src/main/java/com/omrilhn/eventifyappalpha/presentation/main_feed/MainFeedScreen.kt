package com.omrilhn.eventifyappalpha.presentation.main_feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.model.EventCardData
import com.omrilhn.eventifyappalpha.presentation.components.EventCard
import com.omrilhn.eventifyappalpha.utils.Screen

@Composable
fun MainFeedScreen(
    navController: NavController,
    dataList: List<EventCardData>,
    state:SnackbarHostState

){
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(dataList) { data ->
            EventCard(data = data, onClicked = {Screen.MainFeedScreen.route})
        }
    }
}