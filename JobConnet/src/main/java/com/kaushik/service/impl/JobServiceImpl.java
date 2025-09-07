package com.kaushik.service.impl;

import com.kaushik.entity.Job;
import com.kaushik.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
   private Long nextId = 1L;   //Incrementing id without database

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);   //Incrementing id without database
       jobs.add(job);

    }

    @Override
    public Job findById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }


}
