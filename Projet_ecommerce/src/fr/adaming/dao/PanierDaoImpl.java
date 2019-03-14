package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@Stateless
public class PanierDaoImpl implements IPanierDao{
	
//	@PersistenceContext(name="PU_proj")
//	private EntityManager em;
//
//	@Override
//	public Panier ajoutLiCo(LigneCommande lc) {
//		Panier p=new Panier();
//		
//		
//		return null;
//	}
//
//	@Override
//	public Panier supprLiCo(LigneCommande lc) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
