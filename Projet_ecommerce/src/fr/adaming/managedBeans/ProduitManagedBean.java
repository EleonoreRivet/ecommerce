package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="pMB")
@RequestScoped
public class ProduitManagedBean  implements Serializable{
	
	//Transformation de l'association UML en Java
	@EJB
	private IProduitService pService; 
	
	// Déclaration des attributs
	private Produit produit;
	private Administrateur admin; 
	private boolean indice;
	
    private HttpSession maSession;

    // Constructeur vide
	public ProduitManagedBean() {
		this.produit= new Produit(); 
		this.indice=false;
	}

	// Getters et Setters
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	@PostConstruct //Cette annotation sert à dire que la méthode doit être exécutée après l'instanciation de l'objet
	public void init(){
		maSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.admin= (Administrateur) maSession.getAttribute("adminSession");
	}
	
	
}
