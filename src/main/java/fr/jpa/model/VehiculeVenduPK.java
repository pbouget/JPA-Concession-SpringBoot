package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vehicule_vendu database table.
 * 
 */
@Embeddable
public class VehiculeVenduPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="id_vente", insertable=false, updatable=false, unique=true, nullable=false)
	private int idVente;

	public VehiculeVenduPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdVente() {
		return this.idVente;
	}
	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VehiculeVenduPK)) {
			return false;
		}
		VehiculeVenduPK castOther = (VehiculeVenduPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idVente == castOther.idVente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idVente;
		
		return hash;
	}
}