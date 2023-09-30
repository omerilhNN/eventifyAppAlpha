package com.omrilhn.eventifyappalpha.presentation.personal_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omrilhn.eventifyappalpha.core.domain.models.Category
import com.omrilhn.eventifyappalpha.core.presentation.personal_detail.CategorizedLazyColumn
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge

@Composable
fun PersonalDetailScreen(
    navController : NavController,
    personalDetailViewModel: PersonalDetailViewModel = hiltViewModel(),
    onSubmitClick : () -> Unit
){

    val eventTypes by personalDetailViewModel.eventTypesFlow.collectAsState(listOf(
        "Live Music",
        "Festival",
        "Konser",
        "Stand up",
        "Tiyatro",
        "Senfoni",
        "DJ Performance"))
    val musicGenres by personalDetailViewModel.musicGenreFlow.collectAsState(listOf(
        "Techno",
        "R&B",
        "House",
        "Metal",
        "Rock",
        "Pop"
    ))


    personalDetailViewModel.updateMusicGenre(listOf(
        "Techno",
        "R&B",
        "House",
        "Metal",
        "Rock",
        "Pop"
    ))


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 40.dp
            )
    ){
        Column(modifier = Modifier.fillMaxSize()){
            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(80.dp),
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 16.dp){

                item(span = StaggeredGridItemSpan.FullLine){
                    Card(modifier = Modifier
                        .padding(8.dp)
                        .align(CenterHorizontally),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ){
                        Text(text = "Events List",
                            modifier = Modifier.align(CenterHorizontally),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                items(eventTypes.size){eventType->
                    Card(modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                        .fillMaxWidth()
                        ,elevation = CardDefaults.cardElevation(8.dp)){
                        Text(text = eventTypes[eventType],
                            modifier = Modifier.align(CenterHorizontally),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 1 )
                    }
                }

            }
            Spacer(modifier = Modifier.height(25.dp))

            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(50 .dp),
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 16.dp){

                item(span = StaggeredGridItemSpan.FullLine){
                    Card(modifier = Modifier
                        .padding(8.dp)
                        .align(CenterHorizontally),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ){
                        Text(text = "Music Genres",
                            modifier = Modifier.align(CenterHorizontally),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                items(musicGenres.size){musicGenre->
                    Card(modifier = Modifier
                        .wrapContentWidth(unbounded = true)
                        .fillMaxWidth()
                        ,elevation = CardDefaults.cardElevation(8.dp)){
                        Text(text = musicGenres[musicGenre],
                            modifier = Modifier.align(CenterHorizontally),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 1 )
                    }
                }

            }

        }

//        Card(modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .align(Alignment.TopCenter),
//            elevation = CardDefaults.cardElevation(6.dp),
//            border = BorderStroke(1.dp,color = Color.Black)
//        ) {
//            LazyColumn(
//                verticalArrangement = Arrangement.spacedBy(space = 8.dp),
//                modifier = Modifier.padding(8.dp),
//                userScrollEnabled = true
//            ) {
//                item {
//                    Text(
//                        text = "Events List:",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.height(height = 8.dp)) // extra space below the heading
//                }
//
//                items(eventTypes) { item ->
//                    Card(modifier = Modifier.padding(8.dp),
//                        elevation = CardDefaults.cardElevation(6.dp),
//                        shape = RoundedCornerShape(3.dp),
//                        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
//                    ) {
//                        Text(
//                            text = item,
//                            fontSize = 20.sp
//                        )
//                    }
//
//                }
//            }
//        }
//
//
//        Spacer(modifier = Modifier.height(SpaceLarge))
//
//        Card(modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .align(Alignment.BottomCenter),
//            elevation = CardDefaults.cardElevation(6.dp),
//            border = BorderStroke(1.dp,color = Color.Black)
//        ) {
//            LazyColumn(
//                verticalArrangement = Arrangement.spacedBy(space = 8.dp),
//                modifier = Modifier.padding(8.dp),
//                userScrollEnabled = true
//            ) {
//                item {
//                    Text(
//                        text = "Music Genre",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.height(height = 8.dp)) // extra space below the heading
//                }
//                items(musicGenres) { item ->
//                    Card(modifier = Modifier.padding(8.dp),
//                        elevation = CardDefaults.cardElevation(6.dp),
//                        shape = RoundedCornerShape(3.dp),
//                        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
//                    ) {
//                        Text(
//                            text = item,
//                            fontSize = 20.sp
//                        )
//                    }
//
//                }
//            }
//        }
//


    }
}

@Preview(showBackground = true)
@Composable
fun PersonalDetailScreenPreview(){
    PersonalDetailScreen(navController = rememberNavController()) {

    }
}