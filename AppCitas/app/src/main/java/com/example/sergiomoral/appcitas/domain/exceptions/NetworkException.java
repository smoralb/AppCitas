package com.example.sergiomoral.appcitas.domain.exceptions;

import javax.annotation.Nonnull;

/**
 * Created by sergiomoral on 25/2/18.
 */

public class NetworkException extends BaseException {


    public NetworkException(@Nonnull Integer code, @Nonnull String errorMessage) {
        super(code, errorMessage);
    }
}
