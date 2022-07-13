package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vehicule_vendu database table.
 * 
 */
@Entity
@Table(name="vehicule_vendu")
public class VehiculeVendu implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VehiculeVenduPK id;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal prix;

	//bi-directional many-to-one association to Vehicule
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vehicule", nullable=false)
	private Vehicule vehicule;

	//bi-directional many-to-one association to Vente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vente", nullable=false, insertable=false, updatable=false)
	private Vente vente;

	public VehiculeVendu() {
	}

	public VehiculeVenduPK getId() {
		return this.id;
	}

	public void setId(VehiculeVenduPK id) {
		this.id = id;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Vente getVente() {
		return this.vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}