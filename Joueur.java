import Liste.Liste;
/**
* Ceci est la classe joueur
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
*/
public class Joueur{
	
	private String pseudo;
	private Liste pionsCaptures;
  
	/** Constructeur de la classe joueur
	 * 
	 * @param pseudo - Le pseudo du joueur
	 */
	public Joueur(java.lang.String pseudo){
		this.pseudo = pseudo;
		this.pionsCaptures = new Liste();
	}
	
	/** Méthode renvoyant la liste des pion capturés
	 * 
	 * @return pionCaptures - Liste des pions capturés
	 */
	public Liste getPionsCaptures(){
		return this.pionsCaptures;
	}
	
	/** Méthode renvoyant le pseudo du joueur
	 * 
	 * @return pseudo - Le pseudo du joueur
	 */
	public java.lang.String getPseudo(){
		return this.pseudo;
	}
	
	/** Méthode permettant d'ajouter un pion à la liste de capture
	 * 
	 * @param pion - Pion ajouté
	 */
	public void ajouterPionCapture(Pion pion){
		this.pionsCaptures.add(pion);
	}
	
	/** Méthode permattant d'obtenir le nombre de pions capturés
	 * 
	 * @return Taille de la liste pionsCaptures
	 */
	public int getNbPionsCaptures(){
		if (this.pionsCaptures == null){
			return 0;
		}
		return this.pionsCaptures.size();
	}
  
	/**Redéfinition de la méthode equals()
	 * 
	 * @return true si les pseudo sont egaux, false sinon
	 */
	public boolean equals(java.lang.Object o){
		if (o instanceof Joueur){
			return this.pseudo.equals(((Joueur)o).pseudo);
		}
		return false;
	}
  
	/** Méthode permettant de calculer le score du joueur
	 * 
	 * @return score - Le score du joueur
	 */
	public int calculerScore(){	
		int score;
		score = 0;
		if (this.getNbPionsCaptures() != 0){
			for (int i = 0; i < this.pionsCaptures.size(); i++){
				score += ((Pion)this.pionsCaptures.get(i)).getScore();
			}
		}
		return score;
	}
}
