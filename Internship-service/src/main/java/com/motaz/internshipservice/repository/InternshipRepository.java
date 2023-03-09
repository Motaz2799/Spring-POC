package com.motaz.internshipservice.repository;

import com.motaz.internshipservice.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Intern, Long> {
}
