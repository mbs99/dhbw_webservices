package de.dhbw.retrydb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class RetryableDataSource extends AbstractDataSource {

    private static final Logger log = LoggerFactory.getLogger(RetryableDataSource.class);

    private final DataSource dataSource;

    public RetryableDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 1.3, maxDelay = 10000))
    public Connection getConnection() throws SQLException {
        log.info("getting connection ...");
        return dataSource.getConnection();
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 2.3, maxDelay = 10000))
    public Connection getConnection(String username, String password) throws SQLException {
        log.info("getting connection by username and password ...");
        return dataSource.getConnection(username, password);
    }
}
