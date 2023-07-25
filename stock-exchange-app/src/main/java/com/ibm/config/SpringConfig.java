package com.ibm.config;

	import java.util.Properties;			

	import javax.sql.DataSource;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

	import com.mchange.v2.c3p0.ComboPooledDataSource;

	@Configuration
	@ComponentScan(basePackages = { "com.ibm" })
	public class SpringConfig {
		
		@Bean
		public LocalSessionFactoryBean sessionFactory()
		{
			LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource());
			sessionFactoryBean.setHibernateProperties(hibernateProperties());
			sessionFactoryBean.setPackagesToScan("com.ibm.model");
			return sessionFactoryBean;
		}

		@Bean
		public DataSource dataSource() {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(10);
			dataSource.setMaxIdleTime(5000);
			return dataSource;
		}
		
		private Properties hibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			properties. setProperty("hibernate.show_sql", "true");
			return properties;
		}

	}

