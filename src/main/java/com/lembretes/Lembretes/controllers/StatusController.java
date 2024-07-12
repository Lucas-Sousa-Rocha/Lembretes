package com.lembretes.Lembretes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lembretes.Lembretes.Models.Entities.Status;
import com.lembretes.Lembretes.Models.Repositories.StatusRepository;


@Controller
public class StatusController {

    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/cadastrostatus")
    public String cadastroStatus(){
        return "cadastroStatus";
    } 

    /*@GetMapping("/cadastrostatus")
	public String showCreateForm(Model model) {
		model.addAttribute("status", new Status());
		return "/home";
	}*/

    @PostMapping(path = "/cadastrostatus")
	public String salvarStatus( Status status) {
		statusRepository.save(status);
		return "redirect:/home";
	}
}
