package com.melck.carrertoolms.repositories;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
