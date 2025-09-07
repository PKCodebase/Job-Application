package com.kaushik.service;

import com.kaushik.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job findById(Long id);
}
