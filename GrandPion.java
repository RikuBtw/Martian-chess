import Liste.Liste;
/**
* Ceci est la classe Grand Pion
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
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
		Liste deplacements = new Liste();
		//Si on a un déplacement vertical, on lance cette fonction
		if (coordArriveeX-coordDepartX != 0 && coordArriveeY-coordDepartY == 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeX-coordDepartX);
			//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeX < coordDepartX){
				for(int i=1;i<=compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX-i,coordDepartY));
				}
			}
			//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeX > coordDepartX){
				for(int i=1;i<=compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX+i,coordDepartY));
				}
			}
		}
		return deplacements;
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
		Liste deplacements = new Liste();
		//Si on a un déplacement horizontal, on lance cette fonction
		if (coordArriveeX-coordDepartX == 0 && coordArriveeY-coordDepartY != 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeY-coordDepartY);
			//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeY < coordDepartY){
				for(int i=1;i<=compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX,coordDepartY-i));
				}
			}
			//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
			if (coordArriveeY > coordDepartY){
				for(int i=1;i<=compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX,coordDepartY+i));
				}
			}
		}
		return deplacements;
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
		Liste deplacements = new Liste();
		//Si on a un déplacement diagonal, on lance cette fonction
		if (coordArriveeX - coordDepartX == coordArriveeY - coordDepartY && coordArriveeX - coordDepartX != 0){
			//On détermine le nombre de cases à parcourir.
			int compteur = Math.abs(coordArriveeX-coordDepartX);
			//Diagonale Haut-Gauche
			if (coordArriveeX < coordDepartX && coordArriveeX < coordArriveeY){
				for(int i=1;i <= compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX-i,coordDepartY-i));
				}
			}
			//Diagonale Haut-Droite
			if (coordArriveeX < coordDepartX && coordArriveeX > coordArriveeY){
				for(int i=1;i <= compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX-i,coordDepartY+i));
				}
			}
			//Diagonale Bas-Gauche
			if (coordArriveeX > coordDepartX && coordArriveeX < coordArriveeY){
				for(int i=1;i <= compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX+i,coordDepartY-i));
				}
			}
			//Diagonale Bas-Droite
			if (coordArriveeX > coordDepartX && coordArriveeX > coordArriveeY){
				for(int i=1;i <= compteur;i++){
					deplacements.add(new Coordonnee(coordDepartX+i,coordDepartY+i));
				}
			}
		}
		return deplacements;
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
		Liste deplacements = new Liste();
		if (coordArriveeX-coordDepartX != 0 && coordArriveeY-coordDepartY == 0){
			deplacements = this.getCheminHorizontal(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		}
		if (coordArriveeX-coordDepartX == 0 && coordArriveeY-coordDepartY != 0){
			deplacements = this.getCheminVertical(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		}
		if (coordArriveeX - coordDepartX == coordArriveeY - coordDepartY && coordArriveeX - coordDepartX != 0){
			deplacements = this.getCheminDiagonal(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY);
		}
		return deplacements;
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
		String chaine;
		chaine = " □ ";
		return chaine;
	}
}
