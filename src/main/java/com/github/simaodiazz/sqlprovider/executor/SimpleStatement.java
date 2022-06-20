package com.github.simaodiazz.sqlprovider.executor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

@AllArgsConstructor
public class SimpleStatement implements AutoCloseable {

    private final PreparedStatement preparedStatement;

    @Contract("_ -> new")
    public static @NotNull SimpleStatement of(PreparedStatement preparedStatement) {
        return new SimpleStatement(preparedStatement);
    }

    @SneakyThrows
    public void set(int parameterIndex, Object value) {
        preparedStatement.setObject(parameterIndex, value);
    }

    @SneakyThrows
    public void executeUpdate() {
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public SimpleResultSet executeQuery() {
        return new SimpleResultSet(preparedStatement.executeQuery());
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
    }
}