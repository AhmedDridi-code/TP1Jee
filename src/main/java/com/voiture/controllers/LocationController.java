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
import com.voiture.services.LocationService;

@Controller
public class LocationController {
	
	
	@Autowired
	LocationService service;
	@RequestMapping("/addLocation")
	public String addVoitureForm(Model model) {
		Location location = new Location();
		model.addAttribute("locationForm", location);
		List<Client> listClient = service.listClient();
		model.addAttribute("listClient", listClient);
		List<Voiture> listVoiture = service.listVoiture();
		model.addAttribute("listVoiture", listVoiture);
		
		return "new_location";	
	}
	@PostMapping("/addLocation")
	public String addVoiture(@ModelAttribute("locationForm") Location location,Model model) {
		service.saveLocation(location);
		return "redirect:/Location";
	}
	@RequestMapping(value="/Location", method=RequestMethod.GET)
	public String listLocation(Model model) {
		List<Location> listLocations = service.listLocation();
		model.addAttribute("listVoiture", listLocations);
		return "liste-location";
		}
	@GetMapping("deleteLocation/{id}")
	public String deleteLocation(@PathVariable("id") long id,Model model) {
		service.deleteLocation(id);
		return "redirect:/Location";
	}

}
