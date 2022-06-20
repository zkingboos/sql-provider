package com.github.simaodiazz.sqlprovider;

import java.sql.Connection;

public interface Database {

    DatabaseType getType();
    Connection getConnection();

}