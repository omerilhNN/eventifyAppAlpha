package com.omrilhn.eventifyappalpha.core.domain.models

data class Re(
    val dateTime: String,
    val detail: String,
    val expectedParticipants: String,
    val featuredImage: String,
    val id: Int,
    val location: String,
    val priceRange: String,
    val title: String
)