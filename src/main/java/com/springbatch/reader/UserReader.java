package com.springbatch.reader;

import com.springbatch.mapper.UserRowMapper;
import com.springbatch.model.User;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserReader {

    @Autowired
    @Qualifier("citywebJdbcTemplate")
    private JdbcTemplate cityWebTemplate;

    private static final String QUERY_SELECT_USER = "SELECT id, name FROM sch_spring_batch.user";

    @Bean
    public JdbcCursorItemReader<User> reader(){
        JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<User>();
        reader.setDataSource(this.cityWebTemplate.getDataSource());
        reader.setSql(QUERY_SELECT_USER);
        reader.setRowMapper(new UserRowMapper());

        return reader;
    }
}
