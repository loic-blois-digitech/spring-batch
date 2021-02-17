package com.springbatch.writer;

import com.springbatch.model.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserWriter {

    @Autowired
    @Qualifier("evelinBoJdbcTemplate")
    private JdbcTemplate evelinBoTemplate;

    private static final String QUERY_INSERT_USER = "INSERT INTO sch_spring_batch.user(id, name) VALUES (:id, :name)";
    @Bean
    public ItemWriter<User> writer() {
        JdbcBatchItemWriter<User> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.evelinBoTemplate.getDataSource());
        databaseItemWriter.setSql(QUERY_INSERT_USER);

        ItemSqlParameterSourceProvider<User> paramProvider = new BeanPropertyItemSqlParameterSourceProvider<>();
        databaseItemWriter.setItemSqlParameterSourceProvider(paramProvider);

        return databaseItemWriter;
    }
}
