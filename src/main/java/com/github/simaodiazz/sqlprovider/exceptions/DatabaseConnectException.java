package com.github.simaodiazz.sqlprovider.exceptions;

import java.sql.SQLException;

public class DatabaseConnectException extends SQLException {

    public DatabaseConnectException(String reason) {
        super(reason);
    }
}