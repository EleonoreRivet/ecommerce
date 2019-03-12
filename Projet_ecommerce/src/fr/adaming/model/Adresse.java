package fr.adaming.model;



public class Adresse {
	private String rue;
	private String Ville;
	private String CP;
	public Adresse() {
		super();
	}
	public Adresse(String rue, String ville, String cP) {
		super();
		this.rue = rue;
		Ville = ville;
		CP = cP;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", Ville=" + Ville + ", CP=" + CP + "]";
	}
	
	

}
