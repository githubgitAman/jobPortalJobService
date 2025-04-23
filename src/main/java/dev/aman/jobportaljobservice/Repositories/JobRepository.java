package dev.aman.jobportaljobservice.Repositories;

import dev.aman.jobportaljobservice.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Job save(Job job);
    List<Job> findAll();
    Optional<Job> findJobById(Long id);
    void deleteJobById(Long id);
}
