import Liste.Liste;
/**
* Ceci est la classe PetitPion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class PetitPion extends Pion{
	
	/** Accesseur donnant le chemin de coordonnées d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement si possible, sinon null
	 */
	public Liste getDeplacement(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY ){
		if ((Math.abs(coordArriveeX - coordDepartX) == 1) && (Math.abs(coordArriveeY - coordDepartY) == 1)){
			deplacements.add(coordArriveeX);
			deplacements.add(coordArriveeY);
		}
		return this.deplacements;
	}
	
	/** Récupère le score d'un pion
	 *
	 * @return La valeur du pion
	 */
	public int getScore(){
		return 1;
	}
	
	/** Redéfinition de String toString()
	 *
	 */
	public String toString(){
		String chaine;
		chaine = "";
		chaine += "│P";
		return chaine;
	}
}
