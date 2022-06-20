package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDB implements Database {

    private final Connection connection;

    @SneakyThrows
    public MariaDB(String user, String password, String host, String database) {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://" + host + "/" + database, user, password);
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