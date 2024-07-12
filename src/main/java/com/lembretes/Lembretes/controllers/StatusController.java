package com.lembretes.Lembretes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lembretes.Lembretes.Models.Entities.Lembretes;
import com.lembretes.Lembretes.Models.Entities.Status;
import com.lembretes.Lembretes.Models.Repositories.StatusRepository;


@Controller
public class StatusController {

    @Autowired
    StatusRepository statusRepository;

    /*@GetMapping("/home-cadastrostatus")
    public String cadastroStatus(){
        return "home-cadastrostatus";
    } */

    /*@GetMapping("/cadastrostatus")
	public String showCreateForm(Model model) {
		model.addAttribute("status", new Status());
		return "/home";
	}*/

    @PostMapping("/home-cadastrostatus")
	public String salvarStatus( Status status) {
		statusRepository.save(status);
		return "redirect:/home";
	}

    @GetMapping("/home-cadastrostatus")
	public ModelAndView verListaStatus() {
		ModelAndView mv = new ModelAndView("home-cadastrostatus");
		Iterable<Status> status = statusRepository.findAll();
		mv.addObject("status", status);
		return mv;
	}

    @GetMapping(path = "/home-cadastro")
	public ModelAndView salvarLembreteTeste( Lembretes lembrete) {
		ModelAndView mv = new ModelAndView("home-cadastro");
		Iterable<Status> status = statusRepository.findAll();
		mv.addObject("status", status);
		return mv;
	}


    @GetMapping("home-verstatus")
    public ModelAndView ver() {
		ModelAndView mv = new ModelAndView("home-verstatus");
		Iterable<Status> status = statusRepository.findAll();
		mv.addObject("status", status);
		return mv;
	}
    /*@GetMapping("/editar/{id}")
	 public ModelAndView obter( @PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("editar");
		Optional<Status> status = statusRepository.findById(id);
		mv.addObject("status", status);
		return mv;
	}*/

}
