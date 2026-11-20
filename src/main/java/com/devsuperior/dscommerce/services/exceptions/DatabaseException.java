package com.devsuperior.dscommerce.services.exceptions;

public class DatabaseException extends RuntimeException { //excecao customizada para ser usada ao falhar operacoes no banco de dados por integridade de dados ou restricoes do banco

    public DatabaseException(String msg) {
        super(msg);
    }
}
