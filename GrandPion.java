import Liste.Liste;
/**
* Ceci est la classe Grand Pion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class GrandPion extends Pion{

	/** Accesseur donnant le chemin de coordonnées horizontal d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement horizontal si possible, sinon null
	 */
	protected Liste getCheminHorizontal(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY ){
		if (coordArriveeX-coordDepartX != 0 && coordArriveeY-coordDepartY == 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeX-coordDepartX);
			//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeX < coordDepartX){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX-i);
					this.deplacements.add(coordDepartY); 
				}
			}
			//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeX > coordDepartX){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX+i);
					this.deplacements.add(coordDepartY);
				}
			}
		}
		return this.deplacements;
	}
	
	/** Accesseur donnant le chemin de coordonnées vertical d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement vertical si possible, sinon null
	 */
	protected Liste getCheminVertical(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY ){
		if (coordArriveeX-coordDepartX == 0 && coordArriveeY-coordDepartY != 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeY-coordDepartY);
			//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeY < coordDepartY){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX);
					this.deplacements.add(coordDepartY-i); 
				}
			}
			//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeY > coordDepartY){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX);
					this.deplacements.add(coordDepartY+i);
				}
			}
		}
		return this.deplacements;
	}
  
	/** Accesseur donnant le chemin de coordonnées diagonal d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement diagonal si possible, sinon null
	 */
	protected Liste getCheminDiagonal(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY ){
		if (coordArriveeX - coordDepartX == coordArriveeY - coordDepartY && coordArriveeX - coordDepartX != 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeX-coordDepartX);
			//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter les coordonnées de départ de 1 en 1 jusqu'à celles d'arrivées.
			if (coordArriveeX < coordDepartX){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX-i);
					this.deplacements.add(coordDepartY-i); 
				}
			}
			//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter les coordonnées de départ de 1 en 1 jusqu'à celles d'arrivées.
			if (coordArriveeX > coordDepartX){
				for(int i=1;i<=compteur;i++){
					this.deplacements.add(coordDepartX+i);
					this.deplacements.add(coordDepartY+i);
				}
			}
		}
		return this.deplacements;
	}
	
	/** Accesseur donnant le chemin de coordonnées d'un pion
	 * 
	 * @param coordDepartX coordonnée horizontale de départ
	 * @param coordDepartY coordonnée verticale de départ
	 * @param coordArriveeX coordonnée horizontale d'arrivée
	 * @param coordArriveeY coordonnée verticale du d'arrivée
	 * @return Liste contenant le chemin de déplacement si possible, sinon null
	 */
	public Liste getDeplacement(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY ){
		this.getCheminHorizontal(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		this.getCheminVertical(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		this.getCheminDiagonal(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		return this.deplacements;
	}
  
	/** Récupère le score d'un pion
	 *
	 * @return La valeur du pion
	 */
	public int getScore(){
		return 3;
	}
	
	/** Redéfinition de String toString()
	 *
	 */
	public String toString(){

	}
}
