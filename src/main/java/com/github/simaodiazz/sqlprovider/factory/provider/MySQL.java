package com.github.simaodiazz.sqlprovider.factory.provider;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements Database {

    private final Connection connection;

    public MySQL(String user, String password, String host, String database) throws SQLException, ClassNotFoundException {
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