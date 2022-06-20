package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB implements Database {

    private final Connection connection;

    public MariaDB(@NotNull String user, @NotNull String password, @NotNull String host, @NotNull String database) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(String.format("jdbc:mariadb://%s/%s", host, database), user, password);
    }

    @Override
    public DatabaseType getType() {
        return DatabaseType.MARIADB;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}