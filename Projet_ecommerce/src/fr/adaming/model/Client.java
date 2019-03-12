package fr.adaming.model;

import java.io.Serializable;
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
	private int idClient;
	private String nomClient;
	private List<String> adresse;
	private String email;
	private String tel;

	@OneToMany(mappedBy="client") 
	private List<Commande> listeco;

	// Déclaration des constructeurs
	public Client() {
		super();
	}
	
	public Client(String nomClient, List<String> adresse, String email, String tel, List<Commande> listeco) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.listeco = listeco;
	}

	public Client(int idClient, String nomClient, List<String> adresse, String email, String tel,
			List<Commande> listeco) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.listeco = listeco;
	}


	// Déclaration des getters et setters

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
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
	

	public List<String> getAdresse() {
		return adresse;
	}

	public void setAdresse(List<String> adresse) {
		this.adresse = adresse;
	}

	// To String
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", listeco=" + listeco + "]";
	}




}
