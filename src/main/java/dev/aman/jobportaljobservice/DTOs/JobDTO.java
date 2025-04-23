package dev.aman.jobportaljobservice.DTOs;

import dev.aman.jobportaljobservice.Models.Job;
import dev.aman.jobportaljobservice.Models.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class JobDTO {
    private String title;
    private String description;
    private String companyName;
    private String location;
    private String employmentType;
    private String experienceLevel;
    private String industry;
    private Double salaryMin;
    private Double salaryMax;
    //Element Collection will create a separate table for storing list of skills required.
    @ElementCollection
    private List<String> skillsRequired;
    private LocalDate applicationDeadline;
    private boolean isActive;
    @ManyToOne
    private User users;

    //Converting DTO to Model
    public static JobDTO fromJob(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setCompanyName(job.getCompanyName());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setEmploymentType(job.getEmploymentType());
        jobDTO.setExperienceLevel(job.getExperienceLevel());
        jobDTO.setIndustry(job.getIndustry());
        jobDTO.setSalaryMin(job.getSalaryMin());
        jobDTO.setSalaryMax(job.getSalaryMax());
        jobDTO.setSkillsRequired(job.getSkillsRequired());
        jobDTO.setApplicationDeadline(job.getApplicationDeadline());
        jobDTO.setActive(job.isActive());
        jobDTO.setUsers(job.getUsers());
        return jobDTO;
    }
    //Converting Model to DTO
    public static Job fromJobDTO(JobDTO jobDTO) {
        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setCompanyName(jobDTO.getCompanyName());
        job.setLocation(jobDTO.getLocation());
        job.setEmploymentType(jobDTO.getEmploymentType());
        job.setExperienceLevel(jobDTO.getExperienceLevel());
        job.setIndustry(jobDTO.getIndustry());
        job.setSalaryMin(jobDTO.getSalaryMin());
        job.setSalaryMax(jobDTO.getSalaryMax());
        job.setSkillsRequired(jobDTO.getSkillsRequired());
        job.setApplicationDeadline(jobDTO.getApplicationDeadline());
        job.setActive(jobDTO.isActive());
        job.setUsers(jobDTO.getUsers());
        return job;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDate applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

