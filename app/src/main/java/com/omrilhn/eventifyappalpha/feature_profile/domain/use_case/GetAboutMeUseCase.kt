package com.omrilhn.eventifyappalpha.feature_profile.domain.use_case

import com.omrilhn.eventifyappalpha.core.domain.models.Resource
import com.omrilhn.eventifyappalpha.core.domain.repository.ProfileRepository
import com.omrilhn.eventifyappalpha.feature_profile.domain.model.AboutMe

class GetAboutMeUseCase(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(): Resource<AboutMe> {
        return repository.getAboutMe()
    }
}