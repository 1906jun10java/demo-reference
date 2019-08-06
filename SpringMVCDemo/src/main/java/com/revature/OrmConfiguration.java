package com.revature;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class OrmConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(System.getenv("DEMO_DB_URL"));
		dataSource.setUsername(System.getenv("DEMO_DB_USERNAME"));
		dataSource.setPassword(System.getenv("DEMO_DB_PASSWORD"));
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return dataSource;
	}
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
		dataSource.setDriverClassName("org.h2.Driver");
		return dataSource;
	}
	// to use H2
	/*
	 * @Bean public DataSource dataSource() { return new EmbeddedDatabaseBuilder()
	 * .generateUniqueName(false) .setName("testdb")
	 * .setType(EmbeddedDatabaseType.H2) .addDefaultScripts()
	 * .setScriptEncoding("UTF-8") .ignoreFailedDrops(true) .build(); }
	 */

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.revature.beans");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.show-sql", "true");
		//hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.import_files", "schema.sql");
		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
