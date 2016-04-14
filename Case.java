/**
* Ceci est la classe case
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
*/
public class Case{
	
	private Joueur joueur;
	private Pion pion;
	
	public Case(){
		this.joueur = null;
		this.pion = null;
	}
	
	/** Méthode testant si la case est libre
	 * 
	 * @return true si la case ne contient pas de pion, false sinon
	 */
	public boolean estLibre(){
		return (this.pion == null);
	}

	/** Accesseur permettant d'obtenir le joueur de la case
	 * 
	 * @return Le joueur de la case
	 */
	public Joueur getJoueur(){
		return this.joueur;
	}

	/** Accesseur permettant d'obtenir le pion de la case
	 * 
	 * @return Le pion de la case
	 */
	public Pion getPion(){
		return this.pion;
	}

	/** Accesseur permettant d'associer un joueur à une case
	 * 
	 * @param joueur - Le joueur que l'on associe 
	 */
	public void setJoueur(Joueur joueur){
		this.joueur = joueur;
	}

	/** Accesseur permettant d'associer un pion à une case
	 * 
	 * @param pion - Le pion que l'on associe
	 */
	public void setPion(Pion pion){
		this.pion = pion;
	}
  
}
