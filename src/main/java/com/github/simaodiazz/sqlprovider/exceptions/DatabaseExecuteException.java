package com.github.simaodiazz.sqlprovider.exceptions;

import java.sql.SQLException;

public class DatabaseExecuteException extends SQLException {

    public DatabaseExecuteException(String reason) {
        super(reason);
    }
}