package com.challenge.curve.vmorapp.di;

import com.challenge.curve.vmorapp.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger App Module.
 */
@Module
public class VmorAppModule {

    private MainActivityViewModel viewModel;

    public VmorAppModule(MainActivityViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Provides
    @Singleton
    MainActivityViewModel mainActivityViewModel() {
        return viewModel;
    }
}
