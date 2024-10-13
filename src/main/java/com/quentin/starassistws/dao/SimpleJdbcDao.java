package com.quentin.starassistws.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;


public class SimpleJdbcDao
{
    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    
    @Autowired
    public void init(@Qualifier("dataSource") DataSource dataSource) { 
    	this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	

}
