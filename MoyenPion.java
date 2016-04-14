import Liste.Liste;
/**
* Ceci est la classe MoyenPion
*
*@author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
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
		if (Math.abs(coordArriveeX - coordDepartX) <= 2 && coordArriveeY - coordDepartY == 0){
			return true;
		}else if (coordArriveeX - coordDepartX == 0 && Math.abs(coordArriveeY - coordDepartY) <= 2){
			return true;
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
		if (this.longueurOk(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) == true){
			//On détermine le nombre de cases à parcourir.
			int compteurX = Math.abs(coordArriveeX-coordDepartX);
			int compteurY = Math.abs(coordArriveeY-coordDepartY);
			//Si On déplace verticalement
			if (compteurX == 0){
				//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
				if (coordArriveeY < coordDepartY){
					for(int i=1;i<=compteurY;i++){
						this.deplacements.add(coordDepartX);
						this.deplacements.add(coordDepartY-i); 
					}
				}
				//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
				if (coordArriveeY > coordDepartY){
					for(int i=1;i<=compteurY;i++){
						this.deplacements.add(coordDepartX);
						this.deplacements.add(coordDepartY+i);
					}
				}
			}
			//Si on déplace horizontalement
			if (compteurY == 0){
				//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
				if (coordArriveeX < coordDepartX){
					for(int i=1;i<=compteurX;i++){
						this.deplacements.add(coordDepartX-i);
						this.deplacements.add(coordDepartY); 
					}
				}
				//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter la coordonnée de départ de 1 en 1 jusqu'à celle d'arrivée.
				if (coordArriveeX > coordDepartX){
					for(int i=1;i<=compteurX;i++){
						this.deplacements.add(coordDepartX+i);
						this.deplacements.add(coordDepartY);
					}
				}
			}
			//Si on déplace diagonalement
			if (compteurX == compteurY){
				//Si la case est sur une coordonnée inférieure à celle de départ, on va decrémenter les coordonnées de départ de 1 en 1 jusqu'à celles d'arrivées.
				if (coordArriveeX < coordDepartX){
					for(int i=1;i<=compteurX;i++){
						this.deplacements.add(coordDepartX-i);
						this.deplacements.add(coordDepartY-i); 
					}
				}
				//Si la case est sur une coordonnée supérieure à celle de départ, on va incrémenter les coordonnées de départ de 1 en 1 jusqu'à celles d'arrivées.
				if (coordArriveeX > coordDepartX){
					for(int i=1;i<=compteurX;i++){
						this.deplacements.add(coordDepartX+i);
						this.deplacements.add(coordDepartY+i);
					}
				}
			}
		}
		return this.deplacements;
	}
	
	/** Redéfinition de String toString()
	 *
	 */
	public int getScore(){
		return 2;
	}
	
	/** Redéfinition de String toString()
	 *
	 */
	public String toString(){

	}
}
