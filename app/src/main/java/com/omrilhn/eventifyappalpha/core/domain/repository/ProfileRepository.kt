package com.omrilhn.eventifyappalpha.core.domain.repository

import android.net.Uri
import com.omrilhn.eventifyappalpha.core.domain.models.Resource
import com.omrilhn.eventifyappalpha.core.domain.models.SimpleResource
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.AboutMe
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.Profile
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.Preference
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.UpdateProfileData

interface ProfileRepository {

    suspend fun getProfile(userId:String) : Resource<Profile>
    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        profilePictureUri: Uri?
    ):SimpleResource

    suspend fun getMusicPrefs():Resource<List<Preference>>
    suspend fun getEventPrefs():Resource<List<Preference>>
    suspend fun getInterests():Resource<List<Preference>>
    suspend fun getAboutMe():Resource<AboutMe>
    suspend fun followUser(userId:String):SimpleResource
    suspend fun unfollowUser(userId:String):SimpleResource

    fun logout()
}