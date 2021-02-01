package com.alkemy.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.alkemy.challenge.model.Professor;
import com.alkemy.challenge.service.IProfessorService;

@Controller
@RequestMapping(value="/professor")
public class ProfessorController {
	
		@Autowired
		private IProfessorService serviceProfessor;
	
		@GetMapping("/index")
		public String mostrarIndex(Model model) {
			List<Professor> lista = serviceProfessor.searchAll();
			model.addAttribute("professor", lista);
			return "professor/saveProfessor";
		}
		
		@GetMapping("/create")
		public String create(Professor professor, Model model) {
			model.addAttribute("professor", serviceProfessor.searchAll());
			return "professor/createProfessor";
		}
		
		@PostMapping("/save")
		public String save(Professor professor, BindingResult result, RedirectAttributes attributes) {
			if(result.hasErrors()) {
				for(ObjectError error:result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
				}
			return "professor/saveProfessor";
			}
			serviceProfessor.save(professor);
			attributes.addFlashAttribute("msg", "La informacion fue guardada con exito");;
			return "redirect:/professor/index";
		}
		
		@GetMapping("/new")
		public String newProfessor(Professor professor, Model model) {
			model.addAttribute("subject", serviceProfessor.searchAll());
			return "professor/newProfessor";
		}

		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") int idProfessor, Model model, RedirectAttributes attributes) {
			serviceProfessor.delete(idProfessor);
			attributes.addFlashAttribute("msg", "La informacion fue eliminada");
			return "redirect:/professor/index";
		}
		
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") int idProfessor, Model model) {
			Professor professor = serviceProfessor.searchById(idProfessor);
			model.addAttribute("professor", professor);
			return "professor/createProfessor";
		}
		
	}

