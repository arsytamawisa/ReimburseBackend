package com.enigma.reimbursment.online.exceptions;

import org.springframework.http.HttpStatus;

public class NotEmailException extends ApplicationException {

    public NotEmailException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".email");
    }
}
