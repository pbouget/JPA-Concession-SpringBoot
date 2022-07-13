package fr.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the couleur database table.
 * 
 */
@Entity
@Table(name="couleur")
public class Couleur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Vehicule
	@OneToMany(mappedBy="couleur")
	@JsonIgnore
	private List<Vehicule> vehicules;

	public Couleur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule addVehicule(Vehicule vehicule) {
		getVehicules().add(vehicule);
		vehicule.setCouleur(this);

		return vehicule;
	}

	public Vehicule removeVehicule(Vehicule vehicule) {
		getVehicules().remove(vehicule);
		vehicule.setCouleur(null);

		return vehicule;
	}

}