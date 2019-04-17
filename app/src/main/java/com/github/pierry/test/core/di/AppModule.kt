package com.github.pierry.test.core.di

import android.app.Application
import com.github.pierry.test.asset.di.AssetComponent
import com.github.pierry.test.form.di.FormComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [
  FormComponent::class,
  AssetComponent::class
])
class AppModule {

  @Provides
  fun providesApplicationContext(application: Application) = application.applicationContext

}