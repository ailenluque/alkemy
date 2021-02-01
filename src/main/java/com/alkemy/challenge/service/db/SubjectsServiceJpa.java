package com.alkemy.challenge.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.model.Subjects;
import com.alkemy.challenge.repository.SubjectsRepository;
import com.alkemy.challenge.service.ISubjectsService;

@Service
@Primary
public class SubjectsServiceJpa implements ISubjectsService{
	
	@Autowired
	private SubjectsRepository repoSubjects;
	
	public void save(Subjects subject) {
		repoSubjects.save(subject);
	}
	

	public List<Subjects> searchAll() {
		return repoSubjects.findAll();
	}

	
	public Subjects searchById(Integer idSubject) {
		Optional<Subjects> optional = repoSubjects.findById(idSubject);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	@Override
	public void delete(Integer idSubject) {
		repoSubjects.deleteById(idSubject);
		
	}
	
	public void edit(Integer idSubject) {
		repoSubjects.findById(idSubject);
		
	}
	
	
}
