package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	@PersistenceContext(name="PU_proj") 
	private  EntityManager em;
	
	@Override
	public Produit ajoutPro(Produit p, Categorie c) {
	
		em.persist(p);
		return p;
	}

	@Override
	public int supprPro(Produit p) {
		// Requ�te JPQL
		String req = "DELETE FROM Produit as p WHERE p.id=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pId", p.getId());
		
		return query.executeUpdate();
	}

	@Override
	public int modifPro(Produit p) {
		// Requ�te JPQL
		
		String req = "UPDATE Produit as p SET p.categorie.id=:pCat, p.designation=:pDes, p.description=:pDesc, p.prix=:pPrix, p.quantite=:pQuantite WHERE p.id=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pId", p.getId());
		query.setParameter("pDes", p.getDesignation());
		query.setParameter("pDesc", p.getDescription());
		query.setParameter("pPrix", p.getPrix());
		query.setParameter("pQuantite", p.getQuantite());
		query.setParameter("pCat", p.getCategorie().getId());
		
		return query.executeUpdate();
	}

	@Override
	public List<Produit> recPro() {
		// Requ�te JPQL
		String req="SELECT p FROM Produit as p"; 
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);

		List<Produit> listePro = query.getResultList();
		
		for(Produit p:listePro){
			p.setImg("data:image/png;base64,"+Base64.encodeBase64String(p.getPhoto()));
		}
		
		return listePro;
	}

	@Override
	public Produit recProById(Produit p) {
		
		Produit pOut = em.find(Produit.class, p.getId());
		pOut.setImg("data:image/png;base64,"+Base64.encodeBase64String(pOut.getPhoto()));
		
		return pOut;
	}

	@Override
	public List<Produit> recProByMC(String mc) {
		// Requ�te JPQL
		String req="SELECT p FROM Produit as p WHERE p.description LIKE :pMC OR p.designation LIKE :pMC"; 
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);

		// Param�tres
		query.setParameter("pMC", "%"+mc+"%");
		
		List<Produit> listePro = query.getResultList();
		
		for(Produit p:listePro){
			p.setImg("data:image/png;base64,"+Base64.encodeBase64String(p.getPhoto()));
		}
		
		return listePro;
		
	}

	@Override
	public List<Produit> recProByCat(Categorie c) {
		// Requ�te JPQL
		String req = "SELECT p FROM Produit as p WHERE p.categorie.id=:pIdc";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pIdc", c.getId());
		
		List<Produit> listePro = query.getResultList();
		
		for(Produit p:listePro){
			p.setImg("data:image/png;base64,"+Base64.encodeBase64String(p.getPhoto()));
		}
		
		return listePro;
		
	}

	@Override
	public List<Produit> recProSelect() {
		// Requ�te JPQL
		String req = "SELECT p FROM Produit as p WHERE p.selectionne=true";
		
		//R�cup�rer un objet de type Query
		Query query=em.createQuery(req);		
		
		return query.getResultList();
	}

}
