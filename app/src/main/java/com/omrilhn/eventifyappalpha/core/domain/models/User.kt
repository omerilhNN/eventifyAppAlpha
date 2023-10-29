package com.omrilhn.eventifyappalpha.core.domain.models

data class User(
    val userId: String,
    val profilePictureUrl: String,
    val username: String,
    val description: String,
    val connectionCount: Int
)