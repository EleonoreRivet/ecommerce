package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

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

	@Override
	public List<LigneCommande> getListeCo() {
			// Requ�te JPQL
			String req="SELECT l FROM LigneCommande as l"; 
			
			//R�cup�rer un objet de type Query
			Query query=em.createQuery(req);

			List<LigneCommande> listeLico = query.getResultList();
			
			return listeLico;
		}
	}
	

