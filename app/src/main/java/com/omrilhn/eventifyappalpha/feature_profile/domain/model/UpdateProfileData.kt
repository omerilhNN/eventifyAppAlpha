package com.omrilhn.eventifyappalpha.feature_profile.domain.model

data class UpdateProfileData(
    val userName: String,
    val bio: String,
    val eventPreferences: List<Preference>,
    val interests: List<Preference>,
    val musicPreferences: List<Preference>,
    val aboutMe:AboutMe
)
