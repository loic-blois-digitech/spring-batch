package com.springbatch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MultipleDBConfig {

    @Bean(name = "citywebDb")
    @ConfigurationProperties(prefix = "db.cityweb")
    @Primary
    public DataSource citywebDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "citywebJdbcTemplate")
    public JdbcTemplate citywebJdbcTemplate(@Qualifier("citywebDb") DataSource dsCityWeb) {
        return new JdbcTemplate(dsCityWeb);
    }

    @Bean(name = "evelinBoDb")
    @ConfigurationProperties(prefix = "db.evelin-bo")
    public DataSource evelinBoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "evelinBoJdbcTemplate")
    public JdbcTemplate evelinBoJdbcTemplate(@Qualifier("evelinBoDb") DataSource dsEvelinBo) {
        return new JdbcTemplate(dsEvelinBo);
    }
}
