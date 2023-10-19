package com.omrilhn.eventifyappalpha.feature_profile.domain.use_case

data class ProfileUseCases(
    val getProfileUseCase: GetProfileUseCase,
    val updateProfileUseCase: UpdateProfileUseCase,
    val getPreferences: GetPreferencesUseCase,
    val setPreferenceSelected: SetPreferencesUseCase,
)