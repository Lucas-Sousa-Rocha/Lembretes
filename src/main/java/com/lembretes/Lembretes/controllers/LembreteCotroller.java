package com.lembretes.Lembretes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lembretes.Lembretes.Models.Entities.Lembretes;
import com.lembretes.Lembretes.Models.Entities.Status;
import com.lembretes.Lembretes.Models.Repositories.LembreteRepository;
import com.lembretes.Lembretes.Models.Repositories.StatusRepository;

@Controller
public class LembreteCotroller {

	@Autowired
	LembreteRepository lembreteRepository;
	@Autowired
    StatusRepository statusRepository;

	

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	/*@GetMapping("/cadastro")
	public String showCreateForm(Model model) {
		model.addAttribute("lembretes", new Lembretes());
		return "cadastro";
	}*/

	
	
	

	@PostMapping(path = "/home-cadastro")
	public String salvarLembrete( Lembretes lembrete) {
		lembreteRepository.save(lembrete);
		return "redirect:/home-verlembretes";
	}

	@RequestMapping("/home-verlembretes")
	public ModelAndView ver() {
		ModelAndView mv = new ModelAndView("home-verlembretes");
		Iterable<Lembretes> lembretes = lembreteRepository.findAll();
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	@RequestMapping("/home-verobservacao/{id}")
	public ModelAndView vizualizacao( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("home-verobservacao");
		Optional<Lembretes> lembretes = lembreteRepository.findById(id);
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	@GetMapping("/home-editar/{id}")
	 public ModelAndView editar( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("home-editar");
		Optional<Lembretes> lembretes = lembreteRepository.findById(id);
		mv.addObject("lembretes", lembretes);
		List<Status> status = statusRepository.findAll();
		mv.addObject("status", status);
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
			return "redirect:/home-verlembretes";
		}else {
			return "redirect:/ver";
		}
		//LembreteRepository.deleteById(id);
        //return "redirect:/verlembretes";  // Redirecionar para a lista após deletar
    }


}
