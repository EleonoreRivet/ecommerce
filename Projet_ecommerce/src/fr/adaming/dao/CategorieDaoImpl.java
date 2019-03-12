package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Stateless
public class CategorieDaoImpl implements ICategorieDao{
	@PersistenceContext(name="PU_proj") 
	private  EntityManager em;

	@Override
	public Categorie ajoutCat(Categorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public int supprCat(Categorie c) {
		// Requ�te JPQL
		String req = "DELETE FROM Categorie as c WHERE c.id=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pId", c.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int modifCat(Categorie c) {
		// Requ�te JPQL
		
		String req = "UPDATE Categorie as c SET c.nom=:pNom, c.description=:pDesc, c.photo=:pPhoto WHERE c.id=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pId", c.getId());
		query.setParameter("pNom", c.getNom());
		query.setParameter("pDesc", c.getDescription());
		query.setParameter("pPhoto", c.getPhoto());
		
		return query.executeUpdate();
	}

	@Override
	public List<Categorie> recCat() {
		// Requ�te JPQL
		String req="SELECT c FROM Categorie as c"; 
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);

		return query.getResultList();
	}

	@Override
	public Categorie recCatById(Categorie c) {
		Categorie cOut = em.find(Categorie.class, c.getId());
		return cOut;
	}
	
	
}
