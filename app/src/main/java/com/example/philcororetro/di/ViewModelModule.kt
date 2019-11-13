package com.example.philcororetro.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.philcororetro.di.base.ViewModelFactory
import com.example.philcororetro.di.base.ViewModelKey
import com.example.philcororetro.ui.viewmodel.ActionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ActionViewModel::class)
    abstract fun bindActionViewModel(actionViewModel: ActionViewModel): ViewModel

   @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
