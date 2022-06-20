package com.github.simaodiazz.sqlprovider.exceptions;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class DatabaseExecuteException extends SQLException {

    public DatabaseExecuteException(@NotNull String reason) {
        super(reason);
    }
}