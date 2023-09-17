package com.yassir.bank.system.exception.handler;

import com.yassir.bank.system.model.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleSQLException(final DataIntegrityViolationException ex) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);

        return new ResponseEntity<>(new Error(HttpStatus.CONFLICT.value(), ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);

        return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
