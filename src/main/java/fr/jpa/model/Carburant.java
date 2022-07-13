package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carburant database table.
 * 
 */
@Entity
@Table(name="carburant")
@NamedQuery(name="Carburant.findAll", query="SELECT c FROM Carburant c")
public class Carburant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Motorisation
	@OneToMany(mappedBy="carburant")
	private List<Motorisation> motorisations;

	public Carburant() {
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

	public List<Motorisation> getMotorisations() {
		return this.motorisations;
	}

	public void setMotorisations(List<Motorisation> motorisations) {
		this.motorisations = motorisations;
	}

	public Motorisation addMotorisation(Motorisation motorisation) {
		getMotorisations().add(motorisation);
		motorisation.setCarburant(this);

		return motorisation;
	}

	public Motorisation removeMotorisation(Motorisation motorisation) {
		getMotorisations().remove(motorisation);
		motorisation.setCarburant(null);

		return motorisation;
	}

}