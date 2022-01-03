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

import com.voiture.entities.Client;
import com.voiture.entities.Facture;
import com.voiture.entities.Location;
import com.voiture.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
		@Autowired
		private ClientService service;
		
		@RequestMapping("/add")
		public String addClient(Model model) {
			Client client = new Client();

			model.addAttribute("clientForm", client);
			return "new_client";	
		}
		
		@RequestMapping(value="/save", method=RequestMethod.POST)
		public String saveClient(@ModelAttribute("clientForm") Client client) {
		service.save(client);
		return "redirect:/client";
		}
		
		@RequestMapping("")
		public String listClient(Model model) {
			List<Client> listClient = service.listAll();
			model.addAttribute("listClient", listClient);
			return "liste-client";
			}
		@GetMapping("/edit/{id}")
		public String showUpdateForm(@PathVariable("id") long id,Model model) {
			Client client = service.get(id);
			model.addAttribute("client",client);
			return "update-client";
		}
		
		@PostMapping("/update/{id}")
		public String showUpdateForm(@PathVariable("id") long id,@Valid Client client,BindingResult result,Model model) {
			if(result.hasErrors()) {
			client.setId(id);
			return "update-client";
			}
			service.save(client);
			//model.addAttribute("voitures",service.listAll());
			return "redirect:/client";
			}
		
		@GetMapping("/delete/{id}")
		public String deleteClient(@PathVariable("id") long id,Model model) {
			service.delete(id);
			model.addAttribute("client",service.listAll());
			return "redirect:/client";
		}
		@GetMapping("/facture/{id}")
		public String afficheFacture(@PathVariable("id") long id,Model model) {
			List<Double> prixLocation=new ArrayList<Double>();
			Client client = service.get(id);
			Facture facture=new Facture();
			List<Location> locations = client.getLocations();
			double PrixTotal = 0;
			System.out.println(locations.size());
			
			if (locations.size()>0) {
				double Njour=0;
				
				for(Location location:locations) {
					
					long difference = location.getDateRetour().getTime()- location.getDateDebut().getTime();
					Njour = Math.floor(difference / (24 * 60 * 60 * 1000));
					System.out.println("nombre jour "+Njour);
					double PrixLocation = Njour*80;
					prixLocation.add(PrixLocation);
					System.out.println("prix location "+PrixLocation);
					PrixTotal=PrixTotal+PrixLocation;
					System.out.println("prix Totale "+PrixTotal);	
			}
			facture.setClient(client);
			facture.setLocation(locations);
			facture.setPrixTotal(PrixTotal);
			facture.setPrixLocation(prixLocation);
			}
			model.addAttribute("facture",facture);
			model.addAttribute("client",client);
			
			
			return "facture_client";
		}
		
		

	}


