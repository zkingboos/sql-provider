package com.github.simaodiazz.sqlprovider.executor;

import com.github.simaodiazz.sqlprovider.exceptions.DatabaseExecuteException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class SimpleStatement implements AutoCloseable {

    private final PreparedStatement preparedStatement;

    @Contract("_ -> new")
    public static @NotNull SimpleStatement of(PreparedStatement preparedStatement) {
        return new SimpleStatement(preparedStatement);
    }

    @SneakyThrows
    public void set(int parameterIndex, Object value) {
        try {
            preparedStatement.setObject(parameterIndex, value);
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }

    @SneakyThrows
    public void executeUpdate() {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }

    @SneakyThrows
    public SimpleResultSet executeQuery() {
        try {
            return new SimpleResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }

    @SneakyThrows
    public void close() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DatabaseExecuteException(e.getMessage());
        }
    }
}