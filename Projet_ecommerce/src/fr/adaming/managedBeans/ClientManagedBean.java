package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.Administrateur;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IPanierService;

@ManagedBean(name="clMB")
@SessionScoped
public class ClientManagedBean implements Serializable {

	//Transformation de l'association UML en Java
	@EJB
	ILigneCommandeDao liService;
	@EJB
	ICommandeService comService;
	@EJB
	IPanierService panService; 
	
	// Déclaration des attributs
	private Client client;
	private Adresse adresse;
	private Panier panier;
	private Commande commande;
	private LigneCommande ligneco;
	private Produit produit;
	private int quantite;
	
    private HttpSession maSession;
	
	// Déclaration des constructeurs
	public ClientManagedBean() {
		this.client = new Client();
		this.adresse = new Adresse();
		this.client.setAdresse(adresse);
	}
	
	// Getters et Setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public LigneCommande getLigneco() {
		return ligneco;
	}

	public void setLigneco(LigneCommande ligneco) {
		this.ligneco = ligneco;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	} 
	
	@PostConstruct //Cette annotation sert à dire que la méthode doit être exécutée après l'instanciation de l'objet
	public void init(){
		maSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.client= (Client) maSession.getAttribute("clientSession");
	}
	
	// Méthodes métiers 
	public String ajoutPro(){
		Produit pAjout = panService.ajoutProduit(produit, quantite);
		return null;
		// EN COURS
		
	}
	
	
	
	
	
	
	
}
