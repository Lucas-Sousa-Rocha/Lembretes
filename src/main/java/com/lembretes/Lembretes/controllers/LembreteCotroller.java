package com.lembretes.Lembretes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		model.addAttribute("lembrete", new Lembretes());
		return "cadastro";
	}

	@PostMapping(path = "/cadastro")
	public /*@ResponseBody*/ String salvarLembrete(/*@Valid*/ Lembretes lembrete) {
		lembreteRepository.save(lembrete);
		return "redirect:/home";
	}

	/* --------------------------------------------------------------- */

	@RequestMapping("/ver")
	public ModelAndView ver() {
		ModelAndView mv = new ModelAndView("verlembretes");
		Iterable<Lembretes> lembretes = lembreteRepository.findAll();
		mv.addObject("lembretes", lembretes);
		return mv;
	}

	/*@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("cadastro");
		Lembretes lembreteFind = Lembretes.stream().filter(Lambretes ->id.equals)
 		return mv;
	}*/

	@DeleteMapping(path = "/excluir/{id}")
    public void excluirProduto(@PathVariable int id){
    	lembreteRepository.deleteById(id);
    }

	/*@GetMapping("/ver")
	public String pagever(){
		return "verlembretes";
	}*/

	

    /*@GetMapping("/ver")
    public String listarLembretes(Model model) {
        List<Lembretes> lembretes = lembreteRepository.findAll();
        model.addAttribute("lembretes", lembretes);
        return "verlembretes";
    }*/
	/*
	 * @DeleteMapping(path = "/{id}")
	 * public void excluirLembrete(@PathVariable int id) {
	 * lembreteRepository.deleteById(id);
	 * }
	 */

	/*
	 * @GetMapping
	 * public ArrayList<Lembretes> obterLembretes(){
	 * return (ArrayList<Lembretes>) lembreteRepository.findAll();
	 * }
	 */

}
