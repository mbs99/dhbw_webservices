package de.dhbw.retrydb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class RetryableDatabasePostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(RetryableDatabasePostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DataSource dataSource) {
            log.info("-----> configuring a retryable datasource for beanName = {}", beanName);
            return new RetryableDataSource(dataSource);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
