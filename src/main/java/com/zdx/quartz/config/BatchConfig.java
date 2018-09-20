package com.zdx.quartz.config;

import com.zdx.quartz.tasks.TaskOne;
import com.zdx.quartz.tasks.TaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author William D X Zheng
 * @date 2018/9/20 20:59
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new TaskOne())
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step1")
                .tasklet(new TaskTwo())
                .build();
    }

    @Bean(name = "job1")
    public Job job1() {
        return jobBuilderFactory.get("job1")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean(name = "job2")
    public Job job2() {
        return jobBuilderFactory.get("job2")
                .flow(step1())
                .build()
                .build();
    }
}
