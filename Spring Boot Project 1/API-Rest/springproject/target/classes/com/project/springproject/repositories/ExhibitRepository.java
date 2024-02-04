package com.project.springproject.repositories;

import com.project.springproject.model.Exhibit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {
}
