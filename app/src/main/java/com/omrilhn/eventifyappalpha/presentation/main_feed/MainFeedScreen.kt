package com.omrilhn.eventifyappalpha.presentation.main_feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import com.omrilhn.eventifyappalpha.core.presentation.components.EventCard
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardTextField
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardToolbar
import com.omrilhn.eventifyappalpha.utils.Screen

@Composable
fun MainFeedScreen(
    imageLoader: ImageLoader,
    snackbarHostState: SnackbarHostState,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: MainFeedViewModel = hiltViewModel()
) {
    val pagingState = viewModel.pagingState.value
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is PostEvent.OnLiked -> {

                }
            }
        }

    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
//        Row(modifier = Modifier.fillMaxWidth()) {
            StandardToolbar(
                onNavigateUp = onNavigateUp,
                title = {
                    StandardTextField(onValueChange = {
                        viewModel.setSearchText(it)
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        leadingIcon = Icons.Default.Search,
                        hint = "Etkinlik,organizatör,sanatçı",
                        error="Sonuç bulunamadı",
                        singleLine = true
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = false,
            )
            //FilterIconButton
//            IconButton(onClick = { }) {
//                Image(imageVector = Icons.Default.FilterAlt, contentDescription = "Filter")
//
//            }
//        }

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(pagingState.items.size) { i ->
                    val eventCard = pagingState.items[i]
                    if (i >= pagingState.items.size - 1 && !pagingState.endReached && !pagingState.isLoading) {
                        viewModel.loadNextPosts()
                    }
                    EventCard(
                        data = eventCard,
                        onEventCardClicked = {
                            onNavigate(Screen.EventDetailScreen.route + "/${eventCard.id}")
                        }
                    )
                    if (i < pagingState.items.size - 1) {
                        Spacer(modifier = Modifier.height(SpaceLarge))
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(90.dp))
                }
            }
            if (pagingState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Center)
                )
            }
        }
    }
}