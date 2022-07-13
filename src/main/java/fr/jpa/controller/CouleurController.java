package fr.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jpa.model.Couleur;
import fr.jpa.repository.CouleurRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/couleur")
public class CouleurController {
	
	@Autowired
	CouleurRepository repository;

	@GetMapping("/all")
	public List<Couleur> findAll()
	{
		return repository.findAll();
	}
	
	
}
