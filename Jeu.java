/**
* Ceci est la classe jeu
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class Jeu{


  public void initialiserPlateau(){
	  Plateau plateau = new Plateau(4,8);
	  plateau.initialiser();
  }
  /**méthode qui sera appelée par le programme principal pour faire jouer un joueur
  */
  public void Jouer(Joueur joueur){

  }
  /**methode qui permet d'initialiser les joueurs
  */
  public void initialiserJoueur(){
	  Joueur joueur1;
	  Joueur joueur2;
  }
  /** Teste les préconditions relatives au déplacement d'un pion dans la grille de jeu
      Cinq préconditions sont à vérifier:
      si au moins une coordonnee des pions n'est pas dans la grille...



  *@param coordDepartX - coordonnée horizontale du point de départ
  *@param coordDepartY - coordonnée verticale du point de départ
  *@param coordArriveeX - coordonnée horizontale du point d'arrivée
  *@param coordArriveeY - coordonnée verticale du point d'arrivée
  @return true si le déplacement a eu lieu, faux sinon
  */
  private boolean deplacementPossible(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY, Joueur joueur){

  }
  /** Effectue le déplacement d'un pion en modifiant ses coordonnées (coordonnées de départ) qui prennent pour valeur les coordonnées d'arrivée.
  Si un pion adverse a pour coordonnées, les coordonnées d'arrivée du pion déplacé alors il est capturé.
  préconditions: le déplacement est potentiellement possible dans la grille de jeu
  *@param coordDepartX - la coordonnée horizontale de la case dont le joueur veut déplacer le pion
  *@param coordDepartY - la coordonnée verticale de la case dont le joueur veut déplacer le pion
  *@param coordArriveeX - la coordonnée horizontale de la case où le joueur veut déplacer le pion
  *@param coordArriveeY - la coordonnée verticale de la case où le joueur veut déplacer le pion
  @return true si le déplacement a eu lieu, faux sinon
  */
public boolean deplacer(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY, Joueur joueur){

  }
  /** donne le joueur gagnant
  @return le joueur gagnant ou null si les 2 joueurs sont ex aequo
  */
public Joueur joueurVainqueur(){
	
}
/** permet de savoir si la partie est finie ou non
@return true si la partie est finie, false sinon
*/
public boolean arretPartie(){

}
public String toString(){

}
}
