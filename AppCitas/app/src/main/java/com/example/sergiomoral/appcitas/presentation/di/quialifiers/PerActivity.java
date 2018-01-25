package com.example.sergiomoral.appcitas.presentation.di.quialifiers;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sergiomoral on 31/12/17.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
