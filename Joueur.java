import Liste.Liste;
/**
* C'est la classe joueur
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class Joueur{
  private String pseudo;
  private Liste pionsCaptures;
  
  public Joueur(String pseudo, Liste sesPionsCaptures){
      this.pseudo = pseudo;
      this.pionsCaptures = sesPionsCaptures;
  }
  public void ajouterPionCapture(Pion pion){
	  this.pionsCaptures.add(pion);
  }
  public int getNbPionsCaptures(){
	  return this.pionsCaptures.size();
  }
  public boolean equals(Object o){
    if (o instanceof Joueur){
      return this.pseudo.equals(((Joueur)o)pseudo);
    }
    return false;
  }
  public int calculerScore(){
	  int score;
	  for (int i=0; i<=8; i++){
		  score += pionsCaptures.get(i).getscore();
	  }
	  return score;
  }
}
