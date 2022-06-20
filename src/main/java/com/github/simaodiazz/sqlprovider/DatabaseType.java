package com.github.simaodiazz.sqlprovider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DatabaseType {

    MARIADB("MariaDB"),
    MYSQL("MySQL"),
    POSTGRESQL("PostgreSQL"),
    SQLITE("SQLite");

    private final String name;

}