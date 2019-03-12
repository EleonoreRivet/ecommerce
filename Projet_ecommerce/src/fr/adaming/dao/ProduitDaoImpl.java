package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	@PersistenceContext(name="PU_proj") 
	private  EntityManager em;
	
	@Override
	public Produit ajoutPro(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public int supprPro(Produit p) {
		// Requête JPQL
		String req = "DELETE FROM Produit as p WHERE p.id=:pId";
		
		//Récupérer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des paramètres
		query.setParameter("pId", p.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int modifPro(Produit p) {
		// Requête JPQL
		
		String req = "UPDATE Produit as p SET p.categorie.id=:pCat, p.designation=:pDes, p.description=:pDesc, p.prix=:pPrix, p.quantite=:pQuantite, p.photo=:pPhoto WHERE p.id=:pId";
		
		//Récupérer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des paramètres
		query.setParameter("pId", p.getId());
		query.setParameter("pDes", p.getDesignation());
		query.setParameter("pDesc", p.getDescription());
		query.setParameter("pPrix", p.getPrix());
		query.setParameter("pQuantite", p.getQuantite());
		query.setParameter("pPhoto", p.getPhoto());
		query.setParameter("pCat", p.getCategorie().getId());
		
		return query.executeUpdate();
	}

	@Override
	public List<Produit> recPro() {
		// Requête JPQL
		String req="SELECT p FROM Produit as p"; 
		
		//Récupérer un objet de type Query
		Query query=em.createQuery(req);

		return query.getResultList();
	}

	@Override
	public Produit recProById(Produit p) {
		Produit pOut = em.find(Produit.class, p.getId());
		return pOut;
	}

}
