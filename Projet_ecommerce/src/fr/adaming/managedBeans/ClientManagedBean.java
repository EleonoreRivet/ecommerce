package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.adaming.dao.ILigneCommandeDao;
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
	
	
	
	
}
