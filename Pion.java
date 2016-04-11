import Liste.Liste;
/**
* Ceci est la classe Pion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public abstract class Pion{

  /**récupère la valeur du score d'un pion
  @return la valeur du score
  */
  public abstract int getScore();
  
  /**donne le chemin de coordonnées que constitue le déplacement du point de départ vers le point d'arrivée
  *@param coordDepartX coordonnée horizontale du point de départ
  *@param coordDepartY coordonnée verticale du point de départ
  *@param coordArriveeX coordonnée horizontale du point d'arrivée
  *@param coordArriveeY coordonnée verticale du point d'arrivée
  @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée si le déplacement est possible (en prenant en compte les spécificités de chaque pion), null sinon
  */
  public abstract Liste getDeplacement(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY);

}
