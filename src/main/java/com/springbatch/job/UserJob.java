package com.springbatch.job;

import com.springbatch.step.UserStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserJob {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private UserStep userStep;

    @Bean
    public Job exportUserJob() {
        return jobBuilderFactory.get("exportUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(this.userStep.stepUser1())
                .end()
                .build();
    }
}
