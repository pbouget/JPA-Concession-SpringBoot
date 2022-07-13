package fr.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the vehicule database table.
 * 
 */
@Entity
@Table(name="vehicule")
public class Vehicule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="date_entree", nullable=false)
	private Timestamp dateEntree;

	@Column(nullable=false)
	private byte occasion;

	@Column(precision=10, scale=2)
	private BigDecimal prix;

	//bi-directional many-to-one association to Couleur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_couleur", nullable=false)
	private Couleur couleur;

	//bi-directional many-to-one association to Modele
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modele", nullable=false)
	private Modele modele;

	//bi-directional many-to-one association to Motorisation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_motorisation", nullable=false)
	private Motorisation motorisation;

	//bi-directional many-to-one association to Stock
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_stock")
	private Stock stock;

	//bi-directional many-to-one association to VehiculeVendu
	@OneToMany(mappedBy="vehicule")
	private List<VehiculeVendu> vehiculeVendus;

	public Vehicule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Timestamp dateEntree) {
		this.dateEntree = dateEntree;
	}

	public byte getOccasion() {
		return this.occasion;
	}

	public void setOccasion(byte occasion) {
		this.occasion = occasion;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Motorisation getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<VehiculeVendu> getVehiculeVendus() {
		return this.vehiculeVendus;
	}

	public void setVehiculeVendus(List<VehiculeVendu> vehiculeVendus) {
		this.vehiculeVendus = vehiculeVendus;
	}

	public VehiculeVendu addVehiculeVendus(VehiculeVendu vehiculeVendus) {
		getVehiculeVendus().add(vehiculeVendus);
		vehiculeVendus.setVehicule(this);

		return vehiculeVendus;
	}

	public VehiculeVendu removeVehiculeVendus(VehiculeVendu vehiculeVendus) {
		getVehiculeVendus().remove(vehiculeVendus);
		vehiculeVendus.setVehicule(null);

		return vehiculeVendus;
	}

}