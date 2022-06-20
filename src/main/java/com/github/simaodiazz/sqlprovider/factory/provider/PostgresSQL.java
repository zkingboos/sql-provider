package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSQL implements Database {

    private final Connection connection;

    public PostgresSQL(@NotNull String user, @NotNull String password, @NotNull String host, @NotNull String database) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.jdbc.Driver");
        connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s/%s", host, database), user, password);
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