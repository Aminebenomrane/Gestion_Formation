package com.sesame.gestionformation.handlers;

import com.sesame.gestionformation.exception.EntityNotFoundException;
import com.sesame.gestionformation.exception.InvalidEntityException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.WebSocket;

@RestControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebSocket websocket){
        final HttpStatus notFound=HttpStatus.NOT_FOUND;
        final ErrorDto errorDto= ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpcode(notFound.value())
                .message(exception.getMessage())

                .build();
        return new ResponseEntity<>(errorDto,notFound);
    }
    public ResponseEntity<ErrorDto>handleException(InvalidEntityException exception, WebSocket websocket){
        final HttpStatus badrequest=HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto= ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpcode(badrequest.value())
                .message(exception.getMessage())

                .build();
        return new ResponseEntity<>(errorDto,badrequest);
    }
}
