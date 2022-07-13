package fr.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jpa.model.Couleur;
import fr.jpa.model.Test;
import fr.jpa.repository.CouleurRepository;
import fr.jpa.repository.TestRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/couleur")
public class CouleurController {
	
	@Autowired
	CouleurRepository couleurRepository;
	
	@Autowired
	TestRepository testRepository;

	@GetMapping("/all")
	public List<Couleur> findAllCouleur()
	{
		return couleurRepository.findAll();
	}
	
	@GetMapping("/allTest")
	public List<Test> findAllTest()
	{
		return testRepository.findAll();
	}
	
}
