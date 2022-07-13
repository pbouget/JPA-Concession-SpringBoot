package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the vente database table.
 * 
 */
@Entity
@Table(name="vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="date_heure", nullable=false)
	private Timestamp dateHeure;

	//bi-directional many-to-one association to VehiculeVendu
	@OneToMany(mappedBy="vente")
	private List<VehiculeVendu> vehiculeVendus;

	//bi-directional many-to-one association to Vendeur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vendeur", nullable=false)
	private Vendeur vendeur;

	public Vente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateHeure() {
		return this.dateHeure;
	}

	public void setDateHeure(Timestamp dateHeure) {
		this.dateHeure = dateHeure;
	}

	public List<VehiculeVendu> getVehiculeVendus() {
		return this.vehiculeVendus;
	}

	public void setVehiculeVendus(List<VehiculeVendu> vehiculeVendus) {
		this.vehiculeVendus = vehiculeVendus;
	}

	public VehiculeVendu addVehiculeVendus(VehiculeVendu vehiculeVendus) {
		getVehiculeVendus().add(vehiculeVendus);
		vehiculeVendus.setVente(this);

		return vehiculeVendus;
	}

	public VehiculeVendu removeVehiculeVendus(VehiculeVendu vehiculeVendus) {
		getVehiculeVendus().remove(vehiculeVendus);
		vehiculeVendus.setVente(null);

		return vehiculeVendus;
	}

	public Vendeur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

}