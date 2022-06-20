package com.github.simaodiazz.sqlprovider.exceptions;

import java.sql.SQLException;

public class DatabaseDisconnectException extends SQLException {

    public DatabaseDisconnectException(String reason) {
        super(reason);
    }
}