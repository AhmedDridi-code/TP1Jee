package com.voiture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voiture.entities.Client;
import com.voiture.entities.Location;
import com.voiture.entities.Voiture;
import com.voiture.services.ClientService;
import com.voiture.services.LocationService;
import com.voiture.services.VoitureService;

@Controller
@RequestMapping("/location")
public class LocationController {
	@Autowired
	LocationService locationService;
	@Autowired
	VoitureService voitureService;
	@Autowired
	ClientService clientService;
	
	@RequestMapping("/add")
	public String addVoitureForm(Model model) {
		Location location = new Location();
		model.addAttribute("locationForm", location);
		List<Client> listClient = clientService.listAll();
		model.addAttribute("listClient", listClient);
		List<Voiture> listVoiture = voitureService.listAll();
		model.addAttribute("listVoiture", listVoiture);
		return "new_location";	
	}
	
	@PostMapping("/save")
	public String addVoiture(@ModelAttribute("locationForm") Location location,Model model) {
		//Voiture voiture = voitureService.get(location.getVoiture().getId());
		//Client client = clientService.get(location.getClient().getId());
		//location.setClient(client);
		//location.setVoiture(voiture);
		locationService.save(location);
		return "redirect:/location";
	}
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listLocation(Model model) {
		List<Location> listLocations = locationService.listAll();
		model.addAttribute("listLocation", listLocations);
		return "liste-location";
		}
	
	@GetMapping("/delete/{id}")
	public String deleteLocation(@PathVariable("id") long id,Model model) {
		locationService.delete(id);
		return "redirect:/location";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id,Model model) {
		Location location = locationService.get(id);
		model.addAttribute("locationForm",location);
		List<Client> listClient = clientService.listAll();
		model.addAttribute("listClient", listClient);
		List<Voiture> listVoiture = voitureService.listAll();
		model.addAttribute("listVoiture", listVoiture);
		
		return "update-location";
	}

}
