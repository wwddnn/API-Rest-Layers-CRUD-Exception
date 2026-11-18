package com.devsuperior.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { //exceção customizada para ser usada quando o recurso não é encontrado

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
