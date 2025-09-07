package com.kaushik.controller;


import com.kaushik.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kaushik.entity.Job;


import java.util.List;

@RestController
@RequestMapping
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return  ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED) ;
    }

//    @GetMapping("/jobs/{id}")
//    public Job getById(@PathVariable Long id){
//
//       Job job = jobService.findById(id);
//       if(job != null)
//           return job;
//       return new Job(1l,"TestJob","Good","222","535","fwwdj");
//
//    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if(job != null)
            return new  ResponseEntity<>(job,HttpStatus.OK);
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
