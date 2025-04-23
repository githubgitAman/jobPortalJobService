package dev.aman.jobportaljobservice.Services;

import dev.aman.jobportaljobservice.Models.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job job);
    Job updateJob(Long id, Job job);
    List<Job> getAllJobs();
    Job getJobById(Long id);
    String deleteJobById(Long id);
}
