package com.omrilhn.eventifyappalpha.feature_profile.domain.use_case

import com.omrilhn.eventifyappalpha.core.domain.models.Resource
import com.omrilhn.eventifyappalpha.core.domain.repository.ProfileRepository
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.Profile

class GetProfileUseCase(private val repository:ProfileRepository) {
    suspend operator fun invoke(userId:String): Resource<Profile>{
        return repository.getProfile(userId)
    }
}