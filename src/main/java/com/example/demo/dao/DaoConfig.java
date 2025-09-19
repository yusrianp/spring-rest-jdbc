package com.example.demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoConfig {
	
	@Bean (name = "dbDao")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dbDaoProdDataSource () {
		return DataSourceBuilder.create().build();
	}
	
	@Bean (name = "jdbcDbDao")
	public JdbcTemplate jdbcDbDao (@Qualifier ("dbDao") DataSource dataSourceDbDao) {
		return new JdbcTemplate(dataSourceDbDao);
	}

}
