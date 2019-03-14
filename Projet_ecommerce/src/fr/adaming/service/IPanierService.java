package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Local
public interface IPanierService {
	
	public void ajoutProduit(Produit p, int quantite);
	public void supprProduit(Produit p);
	public List<LigneCommande> recProduits();
	public int getTaille();
	public double getTotal();
	
	
}
