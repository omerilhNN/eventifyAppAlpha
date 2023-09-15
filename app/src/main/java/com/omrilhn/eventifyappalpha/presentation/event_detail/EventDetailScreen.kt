package com.omrilhn.eventifyappalpha.presentation.event_detail

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader

@Composable
fun PostDetailScreen(
    snackbarHostState: SnackbarHostState,
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: EventDetailViewModel = hiltViewModel(),
    shouldShowKeyboard: Boolean = false
) {
    val state = viewModel.state.value
    val commentTextFieldState = viewModel.commentTextFieldState.value

    val focusRequester = remember {
        FocusRequester()
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        if (shouldShowKeyboard) {
            context.showKeyboard()
            focusRequester.requestFocus()
        }
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
            }
        }

    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colors.surface),
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
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
                            state.post?.let { post ->
                                Image(
                                    painter = rememberImagePainter(
                                        data = state.post.imageUrl,
                                        imageLoader = imageLoader
                                    ),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Post image",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(16f / 9f)
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(SpaceLarge)
                                ) {
                                    ActionRow(
                                        username = state.post.username,
                                        modifier = Modifier.fillMaxWidth(),
                                        onLikeClick = {
                                            viewModel.onEvent(PostDetailEvent.LikePost)
                                        },
                                        onCommentClick = {
                                            context.showKeyboard()
                                            focusRequester.requestFocus()
                                        },
                                        onShareClick = {
                                            context.sendSharePostIntent(post.id)
                                        },
                                        onUsernameClick = {
                                            onNavigate(Screen.ProfileScreen.route + "?userId=${post.userId}")
                                        },
                                        isLiked = state.post.isLiked
                                    )
                                    Spacer(modifier = Modifier.height(SpaceSmall))
                                    Text(
                                        text = state.post.description,
                                        style = MaterialTheme.typography.body2,
                                    )
                                    Spacer(modifier = Modifier.height(SpaceMedium))
                                    Text(
                                        text = stringResource(
                                            id = R.string.x_likes,
                                            post.likeCount
                                        ),
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.body2,
                                        modifier = Modifier.clickable {
                                            onNavigate(Screen.PersonListScreen.route + "/${post.id}")

                                        }
                                    )
                                }
                            }
                        }
                        Image(
                            painter = rememberImagePainter(
                                data = state.post?.profilePictureUrl,
                                imageLoader = imageLoader
                            ),
                            contentDescription = "Profile picture",
                            modifier = Modifier
                                .size(ProfilePictureSizeMedium)
                                .clip(CircleShape)
                                .align(Alignment.TopCenter)
                        )
                        if (state.isLoadingPost) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            items(state.comments) { comment ->
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceLarge,
                            vertical = SpaceSmall
                        ),
                    imageLoader = imageLoader,
                    comment = comment,
                    onLikeClick = {
                        viewModel.onEvent(PostDetailEvent.LikeComment(comment.id))
                    },
                    onLikedByClick = {
                        onNavigate(Screen.PersonListScreen.route + "/${comment.id}")
                    }
                )
            }
        }
        SendTextField(
            state = viewModel.commentTextFieldState.value,
            onValueChange = {
                viewModel.onEvent(PostDetailEvent.EnteredComment(it))
            },
            onSend = {
                viewModel.onEvent(PostDetailEvent.Comment)
            },
            hint = stringResource(id = R.string.enter_a_comment),
            isLoading = viewModel.commentState.value.isLoading,
            focusRequester = focusRequester
        )
    }
}