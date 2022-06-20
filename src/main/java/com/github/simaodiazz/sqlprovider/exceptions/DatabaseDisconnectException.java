package com.github.simaodiazz.sqlprovider.exceptions;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class DatabaseDisconnectException extends SQLException {

    public DatabaseDisconnectException(@NotNull String reason) {
        super(reason);
    }
}