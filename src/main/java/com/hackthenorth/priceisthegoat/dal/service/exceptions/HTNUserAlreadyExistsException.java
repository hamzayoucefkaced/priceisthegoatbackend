package com.hackthenorth.priceisthegoat.dal.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HTNUserAlreadyExistsException extends RuntimeException {
    public HTNUserAlreadyExistsException(final String msg) {
        super(msg);
    }
}
