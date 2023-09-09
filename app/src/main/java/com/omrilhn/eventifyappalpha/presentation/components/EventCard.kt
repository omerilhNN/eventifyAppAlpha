package com.omrilhn.eventifyappalpha.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.model.EventCardData

@Composable
fun EventCard(
        data: EventCardData,
        onClicked: () -> Unit
    ) {
    Card(modifier = Modifier
        .fillMaxWidth(0.8f)
        .padding(5.dp)
        .clickable { onClicked() },
        elevation = CardDefaults.cardElevation(defaultElevation=5.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        colors = CardDefaults.cardColors(containerColor =MaterialTheme.colorScheme.surface)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            //-> Top to bottom -> Image, EventName,Ticketprice,person number,date,place
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter){
                Image(painter = painterResource(id = R.drawable.party_picture),
                    contentDescription ="Event picture",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                )
                Text(text = data.eventName,modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .align(Alignment.TopStart)
                    .alpha(0.6f)
                    ,fontSize = 8.sp,
                    style = TextStyle(background = MaterialTheme.colorScheme.onPrimary),
                    fontWeight = FontWeight.Light,
                )
            }
            Text(text = data.eventName,modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
            Row(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
               ){
                Image(imageVector = Icons.Default.DateRange,contentDescription = null,
                    modifier = Modifier.size(12.dp))
                Text(text = data.ticketPrice, fontSize = 12.sp,
                    textAlign= TextAlign.Start)
            }
        }
    }
}
