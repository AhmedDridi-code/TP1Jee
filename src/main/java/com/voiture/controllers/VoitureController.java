package com.voiture.controllers;

import java.util.ArrayList;
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

import com.voiture.entities.Modele;
import com.voiture.entities.Voiture;
import com.voiture.services.ModeleService;
import com.voiture.services.VoitureService;

@Controller
@RequestMapping("/voiture")
public class VoitureController {
	@Autowired
	private VoitureService service;
	@Autowired
	private ModeleService modeleService;
	
	
	@RequestMapping("/add")
	public String addVoiture(Model model) {
		Voiture voiture = new Voiture();
		List <Modele> listModele = modeleService.listAll(); 
		model.addAttribute("voitureForm", voiture);
		model.addAttribute("listModele",listModele);
		
		return "new_voiture";	
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveVoiture(@ModelAttribute("voitureForm") Voiture voiture) {
		//Modele modele = modeleService.get(voiture.getModele().getId());
		//voiture.setModele(modele);
		service.save(voiture);
return "redirect:/voiture";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listVoiture(Model model) {
		
		List<Voiture> listVoitures = service.listAll();
		
		model.addAttribute("listVoiture", listVoitures);
		return "liste-voitures";
		}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id,Model model) {
		Voiture voiture = service.get(id);
		model.addAttribute("voiture",voiture);
		return "update-voiture";
	}
	@PostMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id,@Valid Voiture voiture,BindingResult result,Model model) {
		if(result.hasErrors()) {
		voiture.setId(id);
		return "update-voiture";
		}
		service.save(voiture);
		//model.addAttribute("voitures",service.listAll());
		return "redirect:/voiture";
		}
	@GetMapping("/delete/{id}")
	public String deleteVoiture(@PathVariable("id") long id,Model model) {
		service.delete(id);
		model.addAttribute("voitures",service.listAll());
		return "redirect:/voiture";
	}
	
	

}
