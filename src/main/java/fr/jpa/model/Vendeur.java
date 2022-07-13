package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendeur database table.
 * 
 */
@Entity
@Table(name="vendeur")
public class Vendeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(nullable=false, length=45)
	private String prenom;

	//bi-directional many-to-one association to Vendeur
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsable")
	private Vendeur vendeur;

	//bi-directional many-to-one association to Vendeur
	@OneToMany(mappedBy="vendeur")
	private List<Vendeur> vendeurs;

	//bi-directional many-to-one association to Ville
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ville")
	private Ville ville;

	//bi-directional many-to-one association to Vente
	@OneToMany(mappedBy="vendeur")
	private List<Vente> ventes;

	public Vendeur() {
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

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Vendeur getVendeur() {
		return this.vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public List<Vendeur> getVendeurs() {
		return this.vendeurs;
	}

	public void setVendeurs(List<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	public Vendeur addVendeur(Vendeur vendeur) {
		getVendeurs().add(vendeur);
		vendeur.setVendeur(this);

		return vendeur;
	}

	public Vendeur removeVendeur(Vendeur vendeur) {
		getVendeurs().remove(vendeur);
		vendeur.setVendeur(null);

		return vendeur;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Vente> getVentes() {
		return this.ventes;
	}

	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}

	public Vente addVente(Vente vente) {
		getVentes().add(vente);
		vente.setVendeur(this);

		return vente;
	}

	public Vente removeVente(Vente vente) {
		getVentes().remove(vente);
		vente.setVendeur(null);

		return vente;
	}

}