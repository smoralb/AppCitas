package com.example.sergiomoral.appcitas.presentation.di.quialifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sergiomoral on 27/2/18.
 */

@Qualifier
@Retention(RUNTIME)
public @interface BaseApiService {
}