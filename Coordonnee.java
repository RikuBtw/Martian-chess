/**
* Ceci est la classe coordonnée
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class Coordonnee{
  private int x;
  private int y;

  public Coordonnee (int x, int y) {
    this.x = x;
    this.y = y;
  }
  /**accesseur qui permet de récupérer la coordonnée en x
*/
  public int getX(){
    return this.x;
  }
  /**accesseur qui permet de récupérer la coordonnée en y
*/
  public int getY(){
    return this.y;
  }
}
