package com.github.simaodiazz.sqlprovider.exceptions;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class DatabaseConnectException extends SQLException {

    public DatabaseConnectException(@NotNull String reason) {
        super(reason);
    }
}