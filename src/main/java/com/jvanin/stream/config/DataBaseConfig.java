package com.jvanin.stream.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:conf/database.properties")
@EnableTransactionManagement
public class DataBaseConfig {

    @Value("${com.jvanin.stream.config.driver}")
    private String driver;

    @Value("${com.jvanin.stream.config.url}")
    private String url;

    @Value("${com.jvanin.stream.config.username}")
    private String username;

    @Value("${com.jvanin.stream.config.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
    LocalContainerEntityManagerFactoryBean  entityManager = new LocalContainerEntityManagerFactoryBean();
    entityManager.setDataSource(dataSource());
    entityManager.setPackagesToScan(new String[] {"com.jvanin.stream.domain"});
    entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    return entityManager;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setUrl(url);
        return driverManagerDataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactoryBean().getObject());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}


