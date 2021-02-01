package com.alkemy.challenge.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.model.Professor;
import com.alkemy.challenge.repository.ProfessorRepository;
import com.alkemy.challenge.service.IProfessorService;

@Service
@Primary
public class ProfessorServiceJpa implements IProfessorService {
	
	@Autowired
	private ProfessorRepository repoProfessor;
	
	public void save(Professor professor) {
		repoProfessor.save(professor);

	}

	public List<Professor> searchAll() {
		return repoProfessor.findAll();
	}

	public Professor searchById(Integer idProfessor) {
		Optional<Professor> optional = repoProfessor.findById(idProfessor);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Integer idProfessor) {
		repoProfessor.deleteById(idProfessor);
		
	}

	public void edit(Integer idProfessor) {
		repoProfessor.findById(idProfessor);
		
	}
	

}
