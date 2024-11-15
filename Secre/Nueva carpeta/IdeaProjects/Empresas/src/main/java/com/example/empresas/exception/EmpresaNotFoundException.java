package com.example.empresas.exception;

public class EmpresaNotFoundException extends RuntimeException{
    public EmpresaNotFoundException(Long id) {
        super("Not found Empresa with id: " + id);
    }
}

