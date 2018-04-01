package com.challenge.curve.vmorapp.di;

import com.challenge.curve.vmorapp.MainActivity;
import com.challenge.curve.vmorapp.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger App Component.
 */
@Singleton
@Component(modules = {VmorAppModule.class})
public interface VmorAppComponent {

    MainActivityViewModel mainActivityViewModel();

    void inject(MainActivity mainActivity);
}
