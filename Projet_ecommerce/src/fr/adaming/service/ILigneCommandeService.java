package fr.adaming.service;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

public interface ILigneCommandeService {
	public LigneCommande ajoutProduit(Produit p, int qte);
}
