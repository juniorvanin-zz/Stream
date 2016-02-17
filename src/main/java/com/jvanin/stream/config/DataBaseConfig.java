package com.jvanin.stream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
    LocalContainerEntityManagerFactoryBean  entityManager = new LocalContainerEntityManagerFactoryBean();
    entityManager.setDataSource(dataSource());
    entityManager.setPackagesToScan(new String[] {"com.jvanin.stream.domain"});
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManager.setJpaVendorAdapter(vendorAdapter);
    entityManager.setJpaProperties(jpaProperties());
    return entityManager;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUsername("stream");
        driverManagerDataSource.setPassword("str34m");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/stream");
        return driverManagerDataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactoryBean().getObject());
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("databasePlatform", "org.hibernate.dialect.PostgreSQL94Dialect");
        properties.setProperty("showSql", "trues");
        return properties;
    }

}


