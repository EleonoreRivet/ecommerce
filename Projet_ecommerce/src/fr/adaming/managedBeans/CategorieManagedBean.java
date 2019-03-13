package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
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
		super();
	}
    
	
	
    
	
}
