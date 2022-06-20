package com.github.simaodiazz.sqlprovider;

import java.sql.Connection;

public interface Database {

    /**
     * Get the type of the database.
     *
     * @return instance of current database type.
     */
    DatabaseType getType();

    /**
     * Get the connection to the database.
     *
     * @return instance of database connection.
     */
    Connection getConnection();

}