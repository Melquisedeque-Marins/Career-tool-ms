package com.melck.carrertoolms.repositories;

import com.melck.carrertoolms.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
