package com.github.simaodiazz.sqlprovider.executor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;

@AllArgsConstructor
public class SimpleResultSet implements AutoCloseable {

    private final ResultSet resultSet;

    @Contract("_ -> new")
    public static @NotNull SimpleResultSet of(ResultSet resultSet) {
        return new SimpleResultSet(resultSet);
    }

    @SneakyThrows
    public Object get(String column) {
        if (resultSet.isBeforeFirst()) {
            throw new UnsupportedOperationException("ResultSet hasn't any result, use next() to search first result!");
        }
        return resultSet.getObject(column);
    }

    @SneakyThrows
    public boolean next() {
        return this.resultSet.next();
    }

    @Override
    @SneakyThrows
    public void close() {
        resultSet.close();
    }
}