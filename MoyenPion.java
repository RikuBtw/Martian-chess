import Liste.Liste;
/**
* Ceci est la classe MoyenPion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
*/
public class MoyenPion extends GrandPion{

	/** Methode testant si la longueur du déplacement est <= 2
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return true si <=2, sinon false
	 */
	public boolean longueurOk(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY){
		//Si on trouve une différence de 2 ou moins entre la coordonnée d'arrivée X et celle de départ ET que Y ne change pas, alors on renvoie true
		if (Math.abs(coordArriveeX - coordDepartX) <= 2 && coordArriveeY - coordDepartY == 0){
			return true;
		//Si on trouve une différence de 2 ou moins entre la coordonnée d'arrivée Y et celle de départ ET que X ne change pas, alors on renvoie true
		}else if (coordArriveeX - coordDepartX == 0 && Math.abs(coordArriveeY - coordDepartY) <= 2){
			return true;
		//Si on trouve la même différence de 2 ou moins entre les coordonnées d'arrivée X&Y et celle de départ, alors on renvoie true
		}else if (Math.abs(coordArriveeX - coordDepartX) == Math.abs(coordArriveeY - coordDepartY) && Math.abs(coordArriveeX - coordDepartX) <= 2){
			return true;
		}
		return false;
	}
	
	/** Accesseur donnant le chemin de coordonnées d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement si possible, sinon null
	 */
	public Liste getDeplacement(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY){
		Liste deplacements = new Liste();
		if (this.longueurOk(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) == true){
			deplacements = super.getDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		}
		return 	deplacements;
	}
	
	/** Récupère le score d'un pion
	 *
	 * @return La valeur du pion
	 */
	public int getScore(){
		return 2;
	}
	
	/** Redéfinition de String toString()
	 *
	 */
	public String toString(){
		String chaine;
		chaine = " ● ";
		return chaine;
	}
}
