package com.omrilhn.eventifyappalpha.core.domain.models

val eventTypes = listOf(
    "Live Music",
    "Festival",
    "DJ Performance",
    "Konser"
).groupBy {
    it.first()
}.toSortedMap()

val musicGenre = listOf(
    "Techno",
    "R&B",
    "House",
    "Metal",
    "Rock",
    "Pop"
).groupBy {
    it.first()
}.toSortedMap()