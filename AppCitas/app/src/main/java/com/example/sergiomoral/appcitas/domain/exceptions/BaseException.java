package com.example.sergiomoral.appcitas.domain.exceptions;


import javax.annotation.Nonnull;

/**
 * Created by sergiomoral on 25/2/18.
 */

public class BaseException extends RuntimeException {

    @Nonnull
    private final Integer code;

    @Nonnull
    private final String errorMessage;

    public BaseException(@Nonnull Integer code, @Nonnull String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Nonnull
    public Integer getCode() {
        return code;
    }

    @Nonnull
    public String getErrorMessage() {
        return errorMessage;
    }
}
