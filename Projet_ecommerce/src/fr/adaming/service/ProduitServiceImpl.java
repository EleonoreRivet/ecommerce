package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService{
	
	//Transformation de l'asso UML en JAVA
	@EJB
	IProduitDao pDao;

	@Override
	public Produit ajoutPro(Produit p) {
		return pDao.ajoutPro(p);
	}

	@Override
	public int supprPro(Produit p) {
		return pDao.supprPro(p);
	}

	@Override
	public int modifPro(Produit p) {
		return pDao.modifPro(p);
	}

	@Override
	public List<Produit> recPro() {
		return pDao.recPro();
	}

	@Override
	public Produit recProById(Produit p) {
		Produit pOut= pDao.recProById(p);
		if(pOut!=null){
			return pOut;
		}else{
			return null;
		}
	}

}
