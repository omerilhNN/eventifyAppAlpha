package com.omrilhn.eventifyappalpha.presentation.event_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardToolbar
import com.omrilhn.eventifyappalpha.presentation.theme.MediumGray
import com.omrilhn.eventifyappalpha.presentation.theme.ProfilePictureSizeMedium
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge

@Composable
fun PostDetailScreen(
    snackbarHostState: SnackbarHostState,
//    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: EventDetailViewModel = hiltViewModel(),
    shouldShowKeyboard: Boolean = false
) {
    val state = viewModel.state.value

    val focusRequester = remember {
        FocusRequester()
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        if (shouldShowKeyboard) {
//            context.showKeyboard()
            focusRequester.requestFocus()
        }
//        viewModel.eventFlow.collectLatest { event ->
//            when (event) {
//                is UiEvent.ShowSnackbar -> {
//                    scaffoldState.snackbarHostState.showSnackbar(
//                        message = event.uiText.asString(context)
//                    )
//                }
//            }
//        }

    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = "Akış",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.surface),
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .offset(y = ProfilePictureSizeMedium / 2f)
                                .clip(MaterialTheme.shapes.medium)
                                .shadow(5.dp)
                                .background(MediumGray)
                        ) {
//                            state.post?.let { post ->
//                                Image(
//                                    painter = rememberImagePainter(
//                                        data = state.post.imageUrl,
//                                        imageLoader = imageLoader
//                                    ),
//                                    contentScale = ContentScale.Crop,
//                                    contentDescription = "Post image",
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .aspectRatio(16f / 9f)
//                                )
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(SpaceLarge)
//                                ) {
//                                    ActionRow(
//                                        username = state.post.username,
//                                        modifier = Modifier.fillMaxWidth(),
//                                        onLikeClick = {
//                                            viewModel.onEvent(PostDetailEvent.LikePost)
//                                        },
//                                        onCommentClick = {
//                                            context.showKeyboard()
//                                            focusRequester.requestFocus()
//                                        },
//                                        onShareClick = {
//                                            context.sendSharePostIntent(post.id)
//                                        },
//                                        onUsernameClick = {
//                                            onNavigate(Screen.ProfileScreen.route + "?userId=${post.userId}")
//                                        },
//                                        isLiked = state.post.isLiked
//                                    )
//                                    Spacer(modifier = Modifier.height(SpaceSmall))
//                                    Text(
//                                        text = state.post.description,
//                                        style = MaterialTheme.typography.body2,
//                                    )
//                                    Spacer(modifier = Modifier.height(SpaceMedium))
//                                    Text(
//                                        text = stringResource(
//                                            id = R.string.x_likes,
//                                            post.likeCount
//                                        ),
//                                        fontWeight = FontWeight.Bold,
//                                        style = MaterialTheme.typography.body2,
//                                        modifier = Modifier.clickable {
//                                            onNavigate(Screen.PersonListScreen.route + "/${post.id}")
//
//                                        }
//                                    )
                        }
                    }
                }
//                        Image(
//                            painter = rememberImagePainter(
//                                data = state.post?.profilePictureUrl,
//                                imageLoader = imageLoader
//                            ),
//                            contentDescription = "Profile picture",
//                            modifier = Modifier
//                                .size(ProfilePictureSizeMedium)
//                                .clip(CircleShape)
//                                .align(Alignment.TopCenter)
//                        )
//                        if (state.isLoadingPost) {
//                            CircularProgressIndicator(
//                                modifier = Modifier.align(Alignment.Center)
//                            )
//                        }
//                    }
//                }
//                Spacer(modifier = Modifier.height(SpaceLarge))
//            }
//            items(state.comments) { comment ->
//                Comment(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(
//                            horizontal = SpaceLarge,
//                            vertical = SpaceSmall
//                        ),
//                    imageLoader = imageLoader,
//                    comment = comment,
//                    onLikeClick = {
//                        viewModel.onEvent(PostDetailEvent.LikeComment(comment.id))
//                    },
//                    onLikedByClick = {
//                        onNavigate(Screen.PersonListScreen.route + "/${comment.id}")
//                    }
//                )
//            }
//        }
//        SendTextField(
//            state = viewModel.commentTextFieldState.value,
//            onValueChange = {
//                viewModel.onEvent(PostDetailEvent.EnteredComment(it))
//            },
//            onSend = {
//                viewModel.onEvent(PostDetailEvent.Comment)
//            },
//            hint = stringResource(id = R.string.enter_a_comment),
//            isLoading = viewModel.commentState.value.isLoading,
//            focusRequester = focusRequester
//        )
//    }
            }
        }
    }
}