package com.omrilhn.eventifyappalpha.di

import android.app.Application
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.google.gson.Gson
import com.omrilhn.eventifyappalpha.core.domain.repository.EventRepository
import com.omrilhn.eventifyappalpha.domain.repository.UserRepository
import com.omrilhn.eventifyappalpha.network.EventApiService
import com.omrilhn.eventifyappalpha.network.UserApi
import com.omrilhn.eventifyappalpha.utils.Constants
import com.omrilhn.eventifyappalpha.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideEventRepository(
        service: EventApiService
    ) = EventRepository(service)
    @Singleton
    @Provides
    fun provideEventService():EventApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventApiService::class.java)
    }

//    @Provides
//    fun provideUserRepository(
//        api:UserApi
//    ) = UserRepository(api)
    @Singleton
    @Provides
    fun provideUserApi(): UserApi {
        return Retrofit.Builder().
        baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
    @Singleton
    @Provides

    fun provideGson(): Gson {
        return Gson()
    }
    @Singleton
    @Provides
    fun provideImageLoader(app:Application): ImageLoader {
        return ImageLoader.Builder(app)
            .crossfade(true)
            .components{
                SvgDecoder(app)
            }
            .build()
    }
}