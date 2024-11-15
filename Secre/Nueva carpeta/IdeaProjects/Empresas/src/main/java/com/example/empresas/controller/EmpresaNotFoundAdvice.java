package com.example.empresas.controller;

import com.example.empresas.exception.EmpresaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmpresaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmpresaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String peliculaNotFoundHandler(EmpresaNotFoundException empresaNotFoundException) {
        return empresaNotFoundException.getMessage();
    }

}
