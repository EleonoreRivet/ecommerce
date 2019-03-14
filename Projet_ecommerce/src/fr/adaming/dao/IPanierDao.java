package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

public interface IPanierDao {
//	public Panier ajoutLiCo(LigneCommande lc);
//	
//	public Panier supprLiCo(LigneCommande lc);

	public List<LigneCommande> recProduits();
	
}
