package com.alkemy.challenge.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.model.Professor;

@Service
public class ProfessorServiceImpl implements IProfessorService{
	
	List<Professor> list = new LinkedList<Professor>();


	public void save(Professor professor) {
		list.add(professor);
		
	}


	public List<Professor> searchAll() {
		return list;
	}


	public Professor searchById(Integer idProfessor) {
		for (Professor p : list) {
			if (p.getId() == idProfessor) {
				return p;
			}
		}
		return null;
	}


	@Override
	public void delete(Integer idProfessor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void edit(Integer idProfessor) {
		// TODO Auto-generated method stub
		
	}
	
}
