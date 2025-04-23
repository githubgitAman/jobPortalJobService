package dev.aman.jobportaljobservice.Services;

import dev.aman.jobportaljobservice.Models.Job;
import dev.aman.jobportaljobservice.Repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfJobService implements JobService {

    private final JobRepository jobRepository;
    public SelfJobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isEmpty()){
            return null;
        }
        Job jobToUpdate = jobOptional.get();
        if(job.getTitle() != null) {
            jobToUpdate.setTitle(job.getTitle());
        }
        if(job.getDescription() != null) {
            jobToUpdate.setDescription(job.getDescription());
        }
        if(job.getCompanyName() != null) {
            jobToUpdate.setCompanyName(job.getCompanyName());
        }
        if(job.getLocation() != null) {
            jobToUpdate.setLocation(job.getLocation());
        }
        if(job.getEmploymentType() != null) {
            jobToUpdate.setEmploymentType(job.getEmploymentType());
        }
        if(job.getExperienceLevel() != null) {
            jobToUpdate.setExperienceLevel(job.getExperienceLevel());
        }
        if(job.getIndustry() != null) {
            jobToUpdate.setIndustry(job.getIndustry());
        }
        if(job.getSalaryMin() != null) {
            jobToUpdate.setSalaryMin(job.getSalaryMin());
        }
        if(job.getSalaryMax() != null) {
            jobToUpdate.setSalaryMax(job.getSalaryMax());
        }
        if(job.getSkillsRequired() != null) {
            jobToUpdate.setSkillsRequired(job.getSkillsRequired());
        }
        if(job.getApplicationDeadline() != null) {
            jobToUpdate.setApplicationDeadline(job.getApplicationDeadline());
        }
        if(job.isActive()) {
            jobToUpdate.setActive(true);
        }
        Job savedJob = jobRepository.save(jobToUpdate);
        return savedJob;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isEmpty()){
            return null;
        }
        return jobOptional.get();
    }

    @Override
    public String deleteJobById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isEmpty()){
            return null;
        }
        jobRepository.deleteById(id);
        jobOptional.get().setActive(false);
        return "Job deleted successfully";
    }
}
