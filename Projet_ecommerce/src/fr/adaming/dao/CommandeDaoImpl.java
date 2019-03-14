package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;

@Stateless
public class CommandeDaoImpl implements ICommandeDao{
	@PersistenceContext(name="PU_proj") 
	private  EntityManager em;

	@Override
	public Commande enregistrerCom(Panier pan, Client c) {
		// Enregistrer le client
		em.persist(c);
		
		// Enregistrer la commande
		Commande com = new Commande();
		com.setClient(c);
		com.setListelico(pan.getListelico());
		em.persist(com);
		
		return com;
	}
	
	
	
}
