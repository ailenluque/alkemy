package com.alkemy.challenge.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.model.Subjects;

@Service
public interface ISubjectsService {
	
	void save(Subjects subject);
	List<Subjects> searchAll();
	Subjects searchById(Integer idSubject);
	void delete(Integer idSubject);
	void edit(Integer idSubject);
	
}
