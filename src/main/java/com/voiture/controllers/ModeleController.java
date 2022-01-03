package com.voiture.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voiture.entities.Client;
import com.voiture.entities.Location;
import com.voiture.entities.Modele;
import com.voiture.services.ClientService;
import com.voiture.services.ModeleService;

@Controller
@RequestMapping("/modele")
public class ModeleController {
	
		@Autowired
		private ModeleService service;

		
		
		@RequestMapping("/add")
		public String addClient(Model model) {
			Modele modele = new Modele();
			model.addAttribute("modeleForm",modele);
			
			return "new_modele";	
		}
		
		@RequestMapping(value="/save", method=RequestMethod.POST)
		public String saveClient(@ModelAttribute("modeleForm") Modele modele) {
		service.save(modele);
		return "redirect:/modele";
		}
		
		@RequestMapping("")
		public String listClient(Model model) {
			
			List<Modele> listModele = service.listAll();
			
			model.addAttribute("listModeles", listModele);
			return "liste-modele";
			}
		@GetMapping("/edit/{id}")
		public String showUpdateForm(@PathVariable("id") long id,Model model) {
			Modele modele = service.get(id);
			model.addAttribute("modeleForm",modele);
			return "update-modele";
		}
		
		@PostMapping("/update/{id}")
		public String showUpdateForm(@PathVariable("id") long id,@Valid Modele modele,BindingResult result,Model model) {
			if(result.hasErrors()) {
			modele.setId(id);
			return "update-modele";
			}
			service.save(modele);
			//model.addAttribute("voitures",service.listAll());
			return "redirect:/modele";
			}
		
		@GetMapping("/delete/{id}")
		public String deleteClient(@PathVariable("id") long id,Model model) {
			service.delete(id);
			model.addAttribute("modeleForm",service.listAll());
			return "redirect:/modele";
		}
		
		

	}


