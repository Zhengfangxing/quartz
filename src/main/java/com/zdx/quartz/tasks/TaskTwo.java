package com.zdx.quartz.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author William D X Zheng
 * @date 2018/9/20 20:56
 */
@Slf4j
public class TaskTwo implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("MyTaskTwo start...");
        log.info("MyTaskTwo done...");
        return RepeatStatus.FINISHED;
    }
}
