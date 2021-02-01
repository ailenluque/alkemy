package com.alkemy.challenge.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.challenge.model.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	
	Optional<Subjects> findById(Integer id);
}
