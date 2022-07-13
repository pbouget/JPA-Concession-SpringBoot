package fr.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;




/**
 * Classe non liée aux autres juste pour
 * tester l'utilisation d'un type JSON MySQL.
 * voir l'ajout de la dépendance pour le type JSON 
 * avec Hibernate.
   Structure de la table `test`

		CREATE TABLE IF NOT EXISTS `test` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `roles` json DEFAULT NULL,
		  `prenom` varchar(30) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
		
		INSERT INTO `test` (`id`, `roles`, `prenom`) VALUES
		(1, '[\"ADMIN\", \"MEMBRE\"]', 'Philippe'),
		(2, '[\"ADMIN\", \"PROPRIO\"]', 'Timothée');
*/
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String prenom;

	@Type(type = "json")
	@Column(columnDefinition = "json")
	private String[] roles;

	public Test() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}



}