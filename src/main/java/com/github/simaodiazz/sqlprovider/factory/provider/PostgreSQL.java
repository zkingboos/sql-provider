package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQL implements Database {

    private final Connection connection;

    @SneakyThrows
    public PostgreSQL(String user, String password, String host, String database) {
        Class.forName("org.postgresql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://" + host + "/" + database, user, password);
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