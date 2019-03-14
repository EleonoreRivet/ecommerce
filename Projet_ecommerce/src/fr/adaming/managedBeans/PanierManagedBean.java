package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@ManagedBean(name="panMB")
@SessionScoped
public class PanierManagedBean implements Serializable {

	//Transformation de l'association UML en Java
	@EJB
	ILigneCommandeDao liService;
	@EJB
	IPanierService panService; 
	@EJB
	IProduitService pService;
	
	// Déclaration des attributs
	private Panier panier;
	private LigneCommande ligneco;
	private Produit produit;
	private int quantite;
	private double prix; 
	private List<LigneCommande> listeLico;
	private List<Produit> listePro;
	
	// Constructeur
	public PanierManagedBean() {
		this.panier = new Panier();
		this.ligneco = new LigneCommande();
		this.panier.setListelico(listeLico);
		
	}

	// Setters et Getters
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public LigneCommande getLigneco() {
		return ligneco;
	}

	public void setLigneco(LigneCommande ligneco) {
		this.ligneco = ligneco;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<LigneCommande> getListeLico() {
		return listeLico;
	}

	public void setListeLico(List<LigneCommande> listeLico) {
		this.listeLico = listeLico;
	}

	public List<Produit> getListePro() {
		return listePro;
	}

	public void setListePro(List<Produit> listePro) {
		this.listePro = listePro;
	}
	
	
	
	
}
