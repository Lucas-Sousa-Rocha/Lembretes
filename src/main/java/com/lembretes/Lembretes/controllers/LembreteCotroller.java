package com.lembretes.Lembretes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lembretes.Lembretes.Models.Entities.Lembretes;
import com.lembretes.Lembretes.Models.Repositories.LembreteRepository;

@Controller
public class LembreteCotroller {

	@Autowired
	LembreteRepository lembreteRepository;

	

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/cadastro")
	public String showCreateForm(Model model) {
		model.addAttribute("lembretes", new Lembretes());
		return "cadastro";
	}

	@PostMapping(path = "/cadastro")
	public String salvarLembrete( Lembretes lembrete) {
		lembreteRepository.save(lembrete);
		return "redirect:/ver";
	}

	@RequestMapping("/ver")
	public ModelAndView ver() {
		ModelAndView mv = new ModelAndView("verlembretes");
		Iterable<Lembretes> lembretes = lembreteRepository.findAll();
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	@RequestMapping("/vizualizacao/{id}")
	public ModelAndView vizualizacao( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("vizualizacao");
		Optional<Lembretes> lembretes = lembreteRepository.findById(id);
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	@GetMapping("/editar/{id}")
	 public ModelAndView editar( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("editar");
		Optional<Lembretes> lembretes = lembreteRepository.findById(id);
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	/*@DeleteMapping("/excluir/{id}")
	 public String deletarLembrete(@PathVariable("id") Long id) {
        Optional<Lembretes> optionalLembrete = lembreteRepository.findById(id);
		if (optionalLembrete.isPresent()){
			lembreteRepository.deleteById(id);
			return "redirect:/home";
		}else {
			return "redirect:/home";
		}
    }*/
	/* ------------------------------testes--------------------------------- */

	@GetMapping("/excluir/{id}")
	 public String GetLembrete(@PathVariable("id") Long id) {
        Optional<Lembretes> optionalLembrete = lembreteRepository.findById(id);
		if (optionalLembrete.isPresent()){
			lembreteRepository.deleteById(id);
			return "redirect:/ver";
		}else {
			return "redirect:/ver";
		}
		//LembreteRepository.deleteById(id);
        //return "redirect:/verlembretes";  // Redirecionar para a lista após deletar
    }


}
