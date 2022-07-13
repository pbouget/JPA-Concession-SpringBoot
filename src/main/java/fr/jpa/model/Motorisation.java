package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the motorisation database table.
 * 
 */
@Entity
@Table(name="motorisation")
public class Motorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int chevaux;

	@Column(nullable=false)
	private int cylindree;

	//bi-directional many-to-one association to Carburant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_carburant", nullable=false)
	private Carburant carburant;

	//bi-directional many-to-one association to Vehicule
	@OneToMany(mappedBy="motorisation")
	private List<Vehicule> vehicules;

	public Motorisation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChevaux() {
		return this.chevaux;
	}

	public void setChevaux(int chevaux) {
		this.chevaux = chevaux;
	}

	public int getCylindree() {
		return this.cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	public Carburant getCarburant() {
		return this.carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public List<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule addVehicule(Vehicule vehicule) {
		getVehicules().add(vehicule);
		vehicule.setMotorisation(this);

		return vehicule;
	}

	public Vehicule removeVehicule(Vehicule vehicule) {
		getVehicules().remove(vehicule);
		vehicule.setMotorisation(null);

		return vehicule;
	}

}