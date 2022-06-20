package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL implements Database {

    private final Connection connection;

    @SneakyThrows
    public MySQL(String user, String password, String host, String database) {
        Class.forName("org.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, password);
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.MYSQL;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}