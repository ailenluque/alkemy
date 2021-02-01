package com.alkemy.challenge.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.alkemy.challenge.model.Subjects;
import com.alkemy.challenge.repository.SubjectsRepository;

@Controller
public class HomeController {

	@Autowired
	private SubjectsRepository repoSubjects;
		
	
	@GetMapping("/home")
	public String viewHome(Model model) {		
		List<Subjects> list = repoSubjects.findAll(Sort.by("name"));
		model.addAttribute("subjects", list);		
		return "home";
	}
	
}