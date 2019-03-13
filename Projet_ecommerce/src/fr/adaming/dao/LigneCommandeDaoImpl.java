package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao{
	@PersistenceContext(name="PU_proj")
	private EntityManager em;

	@Override
	public LigneCommande ajoutProduit(Produit p, int qte) {
		//instanciation d'une nouvelle ligne de commande
		LigneCommande lc=new LigneCommande();
		
		//ajout du produit
		lc.setProduit(p);
		
		lc.setQuantite(qte);
		
		//calcul du prix
		lc.setPrix(p.getPrix()*qte);
		
		em.persist(lc);
		
		return lc;
	}
	

}
