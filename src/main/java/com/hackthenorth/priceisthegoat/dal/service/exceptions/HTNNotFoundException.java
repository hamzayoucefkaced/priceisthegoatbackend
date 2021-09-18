package com.hackthenorth.priceisthegoat.dal.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HTNNotFoundException extends RuntimeException {
    public HTNNotFoundException(final String msg) {
        super(msg);
    }
}
