package com.venicios.api_credito_nfse.exception;

public class CreditoNotFoundException extends RuntimeException {
    public CreditoNotFoundException(String message) {
        super(message);
    }
}