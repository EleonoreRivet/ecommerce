package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Administrateur;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdministrateurService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AministrateurManagedBean implements Serializable {
	
	//Transformation de l'association UML en Java
	@EJB
	private IAdministrateurService aService;
	@EJB
	private IProduitService pService; 
	@EJB
	private ICategorieService cService; 

	// Déclaration des attributs
	private Administrateur administrateur;

	// Constructeur
	public AministrateurManagedBean() {
		this.administrateur = new Administrateur();
	}

	// Getters et Setters
	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	// Méthodes métiers
	public String seConnecter() {
		Administrateur aOut = aService.existe(administrateur);

		if (aOut != null) {
			//Récupérer la liste des Etudiants du formateur
			List<Produit> listePro =pService.recPro();
			List<Categorie> listeCat =cService.recCat();
			
			//Mettre les listes dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pSession", listePro);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cSession", listeCat);
			
			//Mettre l'admin dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aSession", aOut);
			
			return "espaceadmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mot de passe et/ou login est erroné"));
			return "login";

		}
	}

}
