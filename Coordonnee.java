/**
* Ceci est la classe coordonnée
*
*@author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class Coordonnee{
	private int x;
	private int y;

	/** Constructeur associant les coordonnées à leurs valeurs.
	 * 
	 * @param x coordonnée X
	 * @param y coordonnée Y
	 */
	public Coordonnee (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/** Accesseur qui permet de récupérer la coordonnée en x
	 */
	public int getX(){
		return this.x;
	}
	
	/** Accesseur qui permet de récupérer la coordonnée en y
	 */
	public int getY(){
		return this.y;
	}
}
