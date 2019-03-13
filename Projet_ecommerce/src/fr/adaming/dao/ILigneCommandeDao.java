package fr.adaming.dao;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

public interface ILigneCommandeDao {
	public LigneCommande ajoutProduit(Produit p, int qte);

}
