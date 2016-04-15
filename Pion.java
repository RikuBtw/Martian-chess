import Liste.Liste;
/**
* Ceci est la classe Pion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public abstract class Pion{
	
	protected Liste deplacements;
	
	public Pion(){
		this.deplacements = new Liste();
	}
	
	/** Accesseur récupèrant le score d'un pion.
	 * @return La valeur du score
	 */
	public abstract int getScore();
  
	/** Accesseur donnant le chemin de coordonnées du point de départ vers le point d'arrivée
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
  	 * @return Une liste de coordonnées du déplacement du point de départ vers le point d'arrivée si le déplacement est possible, sinon null
  	 */
	public abstract Liste getDeplacement(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY);

}
