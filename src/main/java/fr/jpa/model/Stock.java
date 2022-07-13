package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@Table(name="stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String entrepot;

	//bi-directional many-to-one association to Ville
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ville")
	private Ville ville;

	//bi-directional many-to-one association to Vehicule
	@OneToMany(mappedBy="stock")
	private List<Vehicule> vehicules;

	public Stock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntrepot() {
		return this.entrepot;
	}

	public void setEntrepot(String entrepot) {
		this.entrepot = entrepot;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule addVehicule(Vehicule vehicule) {
		getVehicules().add(vehicule);
		vehicule.setStock(this);

		return vehicule;
	}

	public Vehicule removeVehicule(Vehicule vehicule) {
		getVehicules().remove(vehicule);
		vehicule.setStock(null);

		return vehicule;
	}

}