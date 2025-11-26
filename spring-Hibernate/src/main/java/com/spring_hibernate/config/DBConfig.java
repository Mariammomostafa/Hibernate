package com.spring_hibernate.config;


import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.spring_hibernate")
public class DBConfig {
	
	@Bean
	public DriverManagerDataSource datasource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/spring-jpa-hibernate");
		datasource.setUsername("root");
		datasource.setPassword("root");
				
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource());
		sessionFactoryBean.setPackagesToScan("com.spring_hibernate.entity");
		sessionFactoryBean.setHibernateProperties(getProperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	public Properties getProperties() {	
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto" , "update");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {	
		
		return new HibernateTransactionManager(sessionFactory);
	}
}
