package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	
	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String nom;
	private String[] adresse; 
	private String email;
	private String tel;
	

	@OneToMany(mappedBy="client") 
	private List<Commande> listeco;

	// Déclaration des constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String[] adresse, String email, String tel) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Client(int id, String nom, String[] adresse, String email, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	// Getters et Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[] getAdresse() {
		return adresse;
	}

	public void setAdresse(String[] adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getListeco() {
		return listeco;
	}

	public void setListeco(List<Commande> listeco) {
		this.listeco = listeco;
	}

	// To String
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + Arrays.toString(adresse) + ", email=" + email
				+ ", tel=" + tel + "]";
	}



	

}
