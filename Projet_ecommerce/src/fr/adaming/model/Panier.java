package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

public class Panier implements Serializable{ 
	private List<LigneCommande> listelico;

	public Panier() {
		super();
	}

	public Panier(List<LigneCommande> listelico) {
		super();
		this.listelico = listelico;
	}

	public List<LigneCommande> getListelico() {
		return listelico;
	}

	public void setListelico(List<LigneCommande> listelico) {
		this.listelico = listelico;
	}

}
