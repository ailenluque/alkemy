package com.alkemy.challenge.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.model.Subjects;
import com.alkemy.challenge.repository.SubjectsRepository;



@Service
public class SubjectsServiceImpl implements ISubjectsService {

	@Autowired
	private SubjectsRepository repoSubjects;
	
	List<Subjects> list = null;
	public SubjectsServiceImpl() {
		list = new LinkedList<Subjects>();
	}

	

	public List<Subjects> searchAll() {
		return list;
	}
	
	public Subjects searchById(Integer idSubject) {
		Optional<Subjects> optional = repoSubjects.findById(idSubject);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


	public void save(Subjects subject) {
		repoSubjects.save(subject);
		
	}



	@Override
	public void delete(Integer idProfessor) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void edit(Integer idSubject) {
		// TODO Auto-generated method stub
		
	}

	
}
