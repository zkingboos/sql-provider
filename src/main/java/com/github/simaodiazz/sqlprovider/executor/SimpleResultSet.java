package com.github.simaodiazz.sqlprovider.executor;

import com.github.simaodiazz.sqlprovider.exceptions.DatabaseExecuteException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class SimpleResultSet implements AutoCloseable {

    private final ResultSet resultSet;

    @Contract("_ -> new")
    public static @NotNull SimpleResultSet of(ResultSet resultSet) {
        return new SimpleResultSet(resultSet);
    }

    @SneakyThrows
    public Object get(String column) {
        try {
            if (resultSet.isBeforeFirst()) {
                throw new DatabaseExecuteException("ResultSet hasn't any result, use next() to search first result!");
            }
            return resultSet.getObject(column);
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }

    @SneakyThrows
    public boolean next() {
        try {
            return this.resultSet.next();
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }

    @SneakyThrows
    public void close() {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }
}