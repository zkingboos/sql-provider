package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite implements Database {

    private final Connection connection;

    public SQLite(@NotNull File file) throws IOException, SQLException, ClassNotFoundException {
        if (!file.exists()) file.createNewFile();
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", file.getAbsolutePath()));
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.SQLITE;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}