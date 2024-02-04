package com.project.springproject.repositories;

import com.project.springproject.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
}
