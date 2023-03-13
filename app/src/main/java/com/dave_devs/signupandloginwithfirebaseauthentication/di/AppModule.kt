package com.dave_devs.signupandloginwithfirebaseauthentication.di

import com.dave_devs.signupandloginwithfirebaseauthentication.data.repository.SignUpLoginRepositoryImpl
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.repository.SignUpLoginRepository
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases.LoginAuthenticationUseCase
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases.SignUpAuthenticationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSignUpLoginRepository(): SignUpLoginRepository {
        return SignUpLoginRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLoginAuthenticationUseCase(): LoginAuthenticationUseCase {
        return LoginAuthenticationUseCase()
    }

    @Provides
    @Singleton
    fun provideSignUpAuthenticationUseCase(): SignUpAuthenticationUseCase {
        return SignUpAuthenticationUseCase()
    }
}