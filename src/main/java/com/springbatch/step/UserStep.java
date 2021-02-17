package com.springbatch.step;

import com.springbatch.model.User;
import com.springbatch.processor.UserItemProcessor;
import com.springbatch.reader.UserReader;
import com.springbatch.writer.UserWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private UserReader userReader;
    @Autowired
    private UserWriter userWriter;

    @Bean
    public Step stepUser1() {
        return stepBuilderFactory.get("stepUser1").<User, User> chunk(10)
                .reader(this.userReader.reader())
                .processor(processor())
                .writer(this.userWriter.writer())
                .build();
    }

    @Bean
    public UserItemProcessor processor(){
        return new UserItemProcessor();
    }
}
