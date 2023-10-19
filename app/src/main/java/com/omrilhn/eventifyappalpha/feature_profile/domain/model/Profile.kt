package com.omrilhn.eventifyappalpha.feature_profile.domain.model

data class Profile(
val userId: String,
val userName:String,
val bio: String,
val followerCount: Int,
val followingCount: Int,
val profilePictureUrl: String,
val eventPreferences: List<Preference>,
val musicPreferences: List<Preference>,
val interests: List<Preference>,
val aboutMe:AboutMe,
val isOwnProfile: Boolean,
val isFollowing: Boolean
)
