public class Case{
	
	private Joueur joueur;
	private Pion pion;
	
	public Case(){
		this.joueur = null;
		this.pion = null;
	}
	
	public boolean estLibre(){
		return (this.pion == null);
	}

	public Joueur getJoueur(){
		return this.joueur;
	}

	public Pion getPion(){
		return this.pion;
	}

	public void setJoueur(Joueur joueur){
		this.joueur = joueur;
	}

	public void setPion(Pion pion){
		this.pion = pion;
	}
  
}
