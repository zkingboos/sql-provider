package com.github.simaodiazz.sqlprovider.factory;

import com.github.simaodiazz.sqlprovider.Database;
import com.github.simaodiazz.sqlprovider.DatabaseType;
import com.github.simaodiazz.sqlprovider.exceptions.DatabaseConnectException;
import com.github.simaodiazz.sqlprovider.exceptions.DatabaseDisconnectException;
import com.github.simaodiazz.sqlprovider.executor.SimpleStatement;
import com.github.simaodiazz.sqlprovider.factory.provider.MariaDB;
import com.github.simaodiazz.sqlprovider.factory.provider.MySQL;
import com.github.simaodiazz.sqlprovider.factory.provider.PostgreSQL;
import com.github.simaodiazz.sqlprovider.factory.provider.SQLite;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
public class DatabaseFactory {

    public Database databaseProvider;
    public DatabaseType databaseType;

    public DatabaseFactory() { }

    public DatabaseFactory(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull DatabaseFactory of() {
        return new DatabaseFactory();
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull DatabaseFactory of(DatabaseType databaseType) { return new DatabaseFactory(databaseType); }

    public String user;
    public String password;
    public String host;
    public String database;
    public File file;

    public String errorMessage;

    public void connect() throws DatabaseConnectException {
        try {
            switch (databaseType) {
                case MARIADB:
                    databaseProvider = new MariaDB(getUser(), getPassword(), getHost(), getDatabase());
                case MYSQL:
                    databaseProvider = new MySQL(getUser(), getPassword(), getHost(), getDatabase());
                case POSTGRESQL:
                    databaseProvider = new PostgreSQL(getUser(), getPassword(), getHost(), getDatabase());
                case SQLITE:
                    databaseProvider = new SQLite(file);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DatabaseConnectException(errorMessage == null ? "Not possible connect "+databaseType.getName() : errorMessage);
        }
    }

    @SneakyThrows
    public SimpleStatement prepareStatement(String arg01) {
        return SimpleStatement.of(databaseProvider.getConnection().prepareStatement(arg01));
    }

    @SneakyThrows
    public void disconnect() {
        try {
            databaseProvider.getConnection().close();
        } catch (SQLException e) {
            throw new DatabaseDisconnectException(e.getMessage());
        }
    }
}