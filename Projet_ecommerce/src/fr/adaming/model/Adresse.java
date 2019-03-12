package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresses")
public class Adresse {
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ad")
	private int id;
	private String rue;
	private String ville;
	private String codePostal;
	
	//Transformation de l'association UML en JAVA
	@OneToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
	private Client client; 
	
	// Constructeurs
	public Adresse() {
		super();
	}
	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	public Adresse(int id, String rue, String ville, String codePostal) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	// Getters et Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	// To String
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	
	


}
