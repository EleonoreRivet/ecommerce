package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Produit;

@Local
public interface IProduitService {
	
	public Produit ajoutPro(Produit p);
	public int supprPro(Produit p);
	public int modifPro(Produit p);
	public List<Produit> recPro(); 
	public Produit recProById(Produit p); 

}
