package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLite implements Database {

    private final Connection connection;

    @SneakyThrows
    public SQLite(@NotNull File file) {
        if (!file.exists()) file.createNewFile();
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.POSTGRESQL;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}