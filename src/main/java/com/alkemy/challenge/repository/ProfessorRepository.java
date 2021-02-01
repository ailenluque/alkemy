package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.challenge.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
