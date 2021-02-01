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
import com.alkemy.challenge.model.Subjects;
import com.alkemy.challenge.service.ISubjectsService;

@Controller
@RequestMapping("/subjects")
public class SubjectsController {

	@Autowired
	private ISubjectsService serviceSubjects;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Subjects> lista = serviceSubjects.searchAll();
		model.addAttribute("subject", lista);
		return "subjects/saveSubjects";
	}

	@GetMapping("/create")
	public String create(Subjects subjects, Model model) {
		model.addAttribute("subject", serviceSubjects.searchAll());
		return "subjects/createSubjects";
	}
	
	@GetMapping("/new")
	public String newSubject(Subjects subjects, Model model) {
		model.addAttribute("subject", serviceSubjects.searchAll());
		return "subjects/newSubjects";
	}

	@PostMapping("/save")
	public String save(Subjects subject, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "subjects/saveSubjects";
		}
		serviceSubjects.save(subject);
		attributes.addFlashAttribute("msg", "La materia fue guardada con exito");
		return "redirect:/subjects/index";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idSubject, Model model, RedirectAttributes attributes) {
		serviceSubjects.delete(idSubject);
		attributes.addFlashAttribute("msg", "La materia fue eliminada");
		return "redirect:/subjects/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idSubject, Model model) {
		Subjects subject = serviceSubjects.searchById(idSubject);
		model.addAttribute("subject", subject);
		return "subjects/createSubjects";
	}
	
	@GetMapping("/view/{id}")
	public String viewDetail(@PathVariable("id") int idSubject, Model model) {

		Subjects subject = serviceSubjects.searchById(idSubject);
		model.addAttribute("subject", subject);

		// buscar los detalles de la vacante en la DB
		return "detail";
	}
	

}
