package dev.aman.jobportaljobservice.Controllers;

import dev.aman.jobportaljobservice.DTOs.JobDTO;
import dev.aman.jobportaljobservice.Models.Job;
import dev.aman.jobportaljobservice.Services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //Create a new Job
    @PutMapping("/create")
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO){
        if(jobDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Job job = JobDTO.fromJobDTO(jobDTO);
        Job createdJob = jobService.createJob(job);
        return new ResponseEntity<>(JobDTO.fromJob(createdJob), HttpStatus.CREATED);
    }
    //Get All jobs
    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs(){
        List<Job> allJobs = jobService.getAllJobs();
        List<JobDTO> jobDTOList = new ArrayList<>();
        for(Job job : allJobs){
            jobDTOList.add(JobDTO.fromJob(job));
        }
        return new ResponseEntity<>(jobDTOList, HttpStatus.OK);
    }
    //Get Job By id
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(JobDTO.fromJob(job), HttpStatus.OK);
    }
    //Update Job
    @PatchMapping("update/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO){
        Job job = JobDTO.fromJobDTO(jobDTO);
        Job updatedJob = jobService.updateJob(id, job);
        return new ResponseEntity<>(JobDTO.fromJob(updatedJob), HttpStatus.OK);
    }
    //Delete Job
    @DeleteMapping("delete/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }
}
