package com.zdx.quartz.jobs;

import lombok.Data;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author William D X Zheng
 * @date 2018/9/20 21:08
 */
@Data
public class QuartzJob extends QuartzJobBean {
    private String jobName;
    private JobLauncher jobLauncher;
    private JobLocator jobLocator;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Job job = jobLocator.getJob(jobName);
            jobLauncher.run(job, new JobParametersBuilder().addDate("time", new Date()).toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
