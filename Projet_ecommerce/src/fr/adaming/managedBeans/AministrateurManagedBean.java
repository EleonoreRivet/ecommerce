package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Administrateur;
import fr.adaming.service.IAdministrateurService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AministrateurManagedBean implements Serializable {
	@EJB
	private IAdministrateurService aService;

	private Administrateur administrateur;

	public AministrateurManagedBean() {
		this.administrateur = new Administrateur();
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public String seConnecter() {
		Administrateur aOut = aService.existe(administrateur);

		if (aOut != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aSession", aOut);
			return "espaceadmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("mot de passe et/ou login est erroné"));
			return "login";

		}
	}

}
