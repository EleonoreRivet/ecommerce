package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateful
public class PanierServiceImpl implements IPanierService{

	List<LigneCommande> articles = new ArrayList<LigneCommande>();
	
	@Override
	public Produit ajoutProduit(Produit p, int quantite) {
		LigneCommande lc = articles.get(p.getId());
		if(lc==null){
			LigneCommande lcOut = new LigneCommande();
			lcOut.setProduit(p);
			lcOut.setQuantite(quantite);
			lcOut.setPrix(p.getPrix());
			articles.add(p.getId(), lcOut);
		}else{
			lc.setQuantite(lc.getQuantite()+quantite);
		}
		return p;
	}

	@Override
	public int supprProduit(Produit p) {
		articles.remove(p.getId());
		return 0;
	}

	@Override
	public List<LigneCommande> recProduits() {
		return articles;
	// A REVOIR 
	}

	@Override
	public int getTaille() {
		return articles.size();
	}

	@Override
	public double getTotal() {
		double total=0;
		for(LigneCommande lc:articles){
			total=lc.getPrix()*lc.getQuantite();
		}
		return total;
	}

}
