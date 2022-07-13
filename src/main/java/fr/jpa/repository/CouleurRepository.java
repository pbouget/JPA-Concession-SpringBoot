package fr.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jpa.model.Couleur;

@Repository
public interface CouleurRepository extends JpaRepository<Couleur, Integer> {

}
