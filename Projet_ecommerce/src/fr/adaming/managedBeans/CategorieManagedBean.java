package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="cMB")
@RequestScoped
public class CategorieManagedBean implements Serializable{

	//Transformation de l'association UML en Java
	@EJB
	private ICategorieService cService;
	
	// Déclaration des attributs
	private Produit produit;
	private Categorie categorie;
	private Administrateur admin; 
	private boolean indice;
	
    private HttpSession maSession;

    // Constructeur
	public CategorieManagedBean() {
		this.categorie= new Categorie();
		this.indice= false;
		this.produit=new Produit();
	}

	// Getters et Setters
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
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
    
	// Méthodes métiers
	public String ajoutCat() {
		//appel de la méthode service
		Categorie cAjout=cService.ajoutCat(categorie);
		
		if(cAjout.getId()!=0) { // pAjout ne sera JAMAIS nul
			
			
			//Récup de la nouvelle liste
			List<Categorie> listeCat=cService.recCat();
			
			//Mettre à jour la liste dans la session
			maSession.setAttribute("cSession", listeCat);
			
			return "espaceadmin"; 
		}else {
			
			//Ajouter un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout a échoué"));
			return "espaceadmin";
		}
		
	}
	
	
    
	
}
