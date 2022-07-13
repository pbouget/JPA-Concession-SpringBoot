package fr.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@Table(name="ville")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String nom;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="ville")
	private List<Stock> stocks;

	//bi-directional many-to-one association to Vendeur
	@OneToMany(mappedBy="ville")
	private List<Vendeur> vendeurs;

	public Ville() {
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

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setVille(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setVille(null);

		return stock;
	}

	public List<Vendeur> getVendeurs() {
		return this.vendeurs;
	}

	public void setVendeurs(List<Vendeur> vendeurs) {
		this.vendeurs = vendeurs;
	}

	public Vendeur addVendeur(Vendeur vendeur) {
		getVendeurs().add(vendeur);
		vendeur.setVille(this);

		return vendeur;
	}

	public Vendeur removeVendeur(Vendeur vendeur) {
		getVendeurs().remove(vendeur);
		vendeur.setVille(null);

		return vendeur;
	}

}