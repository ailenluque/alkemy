package com.alkemy.challenge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.Professor;

@Service
public interface IProfessorService {
	
	void save(Professor professor);
	List<Professor> searchAll();
	Professor searchById(Integer idProfessor);
	void delete(Integer idProfessor);
	void edit(Integer idProfessor);
}
