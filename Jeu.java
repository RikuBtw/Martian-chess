import Liste.Liste;

/**
 * Ceci est la classe jeu
 *
 * @author Julien Aubert-Béduchaud, Nicolas Bourges
 * @version 1.0
 */
public class Jeu{
	
	  Liste liste1 = null;
	  Liste liste2 = null;
	  Joueur joueur1;
	  Joueur joueur2;

	  /**Méthode permettant d'initialiser le plateau.
	   */
	  public void initialiserPlateau(){
		  
		  Plateau plateau = new Plateau(4,8);
		  plateau.initialiser();
	  }
	  
	  /**Méthode qui sera appelée par le programme principal pour faire jouer un joueur
	   */
	  public void Jouer(Joueur joueur){

	  }
	  
	  /**Méthode permettant d'initialiser les joueurs
	   */
	  public void initialiserJoueur(){
		  
		  joueur1 = new Joueur("Joueur 1");
		  joueur2 = new Joueur("Joueur 2"); 
	  }
  
	  /** Teste les préconditions relatives au déplacement d'un pion dans la grille de jeu
	      Cinq préconditions sont à vérifier:
	      Le pion choisi est dans l'espace de jeu.
	      Le chemin du pion reste dans l'espace de jeu.
	      Le pion est sur l'espace du joueur le controllant.
	      Le pion ne peut pas revenir dans la zone adverse juste après avoir été mis dans son camp.
	      Le pion doit respecter son schéma de déplacements.
	   * @param coordDepartX - coordonnée horizontale du point de départ
	   * @param coordDepartY - coordonnée verticale du point de départ
	   * @param coordArriveeX - coordonnée horizontale du point d'arrivée
	   * @param coordArriveeY - coordonnée verticale du point d'arrivée
	   * @return true si le déplacement a eu lieu, false sinon
	   */
	  private boolean deplacementPossible(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY, Joueur joueur){
	
	  }
	  
	  /** Effectue le déplacement d'un pion en modifiant ses coordonnées (coordonnées de départ) qui prennent pour valeur les coordonnées d'arrivée.
	  	  Si un pion adverse a pour coordonnées, les coordonnées d'arrivée du pion déplacé alors il est capturé.
	  	  Préconditions: le déplacement est possible dans la grille de jeu
	   *
	   * @param coordDepartX - la coordonnée horizontale de la case dont le joueur veut déplacer le pion
	   * @param coordDepartY - la coordonnée verticale de la case dont le joueur veut déplacer le pion
	   * @param coordArriveeX - la coordonnée horizontale de la case où le joueur veut déplacer le pion
	   * @param coordArriveeY - la coordonnée verticale de la case où le joueur veut déplacer le pion
	   * @return true si le déplacement a eu lieu, false sinon
	   */
	  public boolean deplacer(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY, Joueur joueur){
		
	  }

	  /** Donne le joueur gagnant
	   * 
	   * @return Le joueur gagnant ou null si les 2 joueurs sont ex aequo
	   */
	  public Joueur joueurVainqueur(){
		  if (this.joueur1.calculerScore() < this.joueur2.calculerScore()){
			  return joueur1;
		  }else if (this.joueur1.calculerScore() > this.joueur2.calculerScore()){
			  return joueur2;
		  }else if (this.joueur1.calculerScore() == this.joueur2.calculerScore()){
			  return null;
		  }
		  return joueur1;
	  }
	  
	  /** Permet de savoir si la partie est finie ou non
	   * 
	   * @return true si la partie est finie, false sinon
	   */
	  public boolean arretPartie(){
		  return ( this.liste1.size() == 8 || this.liste2.size() == 8 );
	  }
	  
	  /** Redifinition de la méthode String toString()
	   * 
	   */
	  public String toString(){

	  }
}
