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
	private String email;
	private String tel;
	
	private Adresse adresse;

	@OneToMany(mappedBy="client") 
	private List<Commande> listeco;

	// Déclaration des constructeurs
	public Client() {
		super();
	}

	public Client(String nomClient, String email, String tel, Adresse adresse, List<Commande> listeco) {
		super();
		this.nomClient = nomClient;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
		this.listeco = listeco;
	}

	public Client(int idClient, String nomClient, String email, String tel, Adresse adresse, List<Commande> listeco) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
		this.listeco = listeco;
	}

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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Commande> getListeco() {
		return listeco;
	}

	public void setListeco(List<Commande> listeco) {
		this.listeco = listeco;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", email=" + email + ", tel=" + tel
				+ ", adresse=" + adresse + ", listeco=" + listeco + "]";
	}
	
	


}
