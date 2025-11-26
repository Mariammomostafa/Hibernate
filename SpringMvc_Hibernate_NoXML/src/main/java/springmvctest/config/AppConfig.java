package springmvctest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("springmvctest")
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig {
	
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring-jpa-hibernate");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("springmvctest.model");
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
