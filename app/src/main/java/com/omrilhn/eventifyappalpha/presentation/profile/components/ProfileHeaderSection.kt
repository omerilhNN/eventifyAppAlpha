package com.omrilhn.eventifyappalpha.presentation.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.core.domain.models.User
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceSmall

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    user: User,
    navController: NavController,
    isFollowing:Boolean = true,
    isOwnProfile:Boolean = true,
    onEditClick: () -> Unit = {},
    onMessageClick: () -> Unit = {}
    ){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .offset(
                x =
                if (isOwnProfile) {
                    (30.dp + SpaceSmall) / 2f
                } else 0.dp
            )
    ) {
        Text(
            text = user.username,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 24.sp
            ),
            textAlign = TextAlign.Center,
        )
        }
        if(!isOwnProfile){
            Spacer(modifier = Modifier.width(SpaceSmall))
            IconButton(onClick = onMessageClick,
                modifier = Modifier.size(30.dp)){
                Icon(imageVector = Icons.Default.Message,
                    contentDescription = "Direct message" )
            }
        }
        if (isOwnProfile) {
            Spacer(modifier = Modifier.width(SpaceSmall))
            IconButton(
                onClick = onEditClick,
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(id = R.string.editTR)
                )
            }
            Spacer(modifier = Modifier.width(SpaceSmall))

        }
    }
        Spacer(modifier = Modifier.height(SpaceMedium))
        if(user.description.isNotBlank()) {
            Text(
                text = user.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
        }
    ProfileNumber(number = user.connectionCount, text = stringResource(id =R.string.connectionsTR  )
        , navController = navController  )

    }