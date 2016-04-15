/**
 * Ceci est la classe jeu
 *
 * @author Julien Aubert-Béduchaud, Nicolas Bourges
 * @version 1.0
 */
public class Jeu{
	
	  private Joueur joueur1;
	  private Joueur joueur2;
	  private Plateau plateau;

	  /**Constructeur de la classe jeu
	   * 
	   * @param sonJoueur1 - Joueur numéro 1
	   * @param sonJoueur2 - Joueur numéro 2
	   */
	  public Jeu(Joueur sonJoueur1, Joueur sonJoueur2){
		  this.joueur1 = sonJoueur1;
		  this.joueur2 = sonJoueur2;
		  this.plateau = null;
				  
	  }
	  
	  /**Méthode permettant d'initialiser le plateau.
	   */
	  public void initialiserPlateau(){
		  
		  plateau = new Plateau(4,8);
		  plateau.initialiser();
		  for (int i = 0; i<= plateau.getTailleHorizontale(); i++){
			  for (int j = 0; j<= plateau.getTailleVerticale()/2; j++){
				  plateau.getCases()[i][j].setJoueur(joueur1);
			  }
		  }
		  for (int i = 0; i<= plateau.getTailleHorizontale(); i++){
			  for (int j = (plateau.getTailleVerticale()/2)+1; j<= plateau.getTailleVerticale(); j++){
				  plateau.getCases()[i][j].setJoueur(joueur2);
			  }
		  }
	  }
	  
	  /**Méthode qui sera appelée par le programme principal pour faire jouer un joueur
	   */
	  public void Jouer(Joueur joueur){

	  }
	  
	  /**Méthode permettant d'initialiser les joueurs
	   */
	  public void initialiserJoueur(){

	  }
  
	  /** Teste les préconditions relatives au déplacement d'un pion dans la grille de jeu
	      Cinq préconditions sont à vérifier:
	      Le pion choisi et la case d'arrivée du pion sont dans l'espace de jeu.
	      Le pion ne peux pas sauter par dessus un autre pion.
	      Le pion est sur l'espace du joueur le controlant.
	      Le joueur ne peut pas capturer son propre pion.
	      Le pion ne peut pas revenir dans la zone adverse juste après avoir été mis dans son camp.
	   * @param coordDepartX - coordonnée horizontale du point de départ
	   * @param coordDepartY - coordonnée verticale du point de départ
	   * @param coordArriveeX - coordonnée horizontale du point d'arrivée
	   * @param coordArriveeY - coordonnée verticale du point d'arrivée
	   * @return true si le déplacement a eu lieu, false sinon
	   */
	  private boolean deplacementPossible(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY, Joueur joueur){
		  
		  //check des coordonnées de départ
		  if(coordDepartX < 0 || coordDepartX > 4 || coordDepartY < 0 || coordDepartY > 7){
			  return false;
		  }
		  //check des coordonnées d'arrivée
		  if(coordArriveeX < 0 || coordArriveeX > 4 || coordArriveeY < 0 || coordArriveeY > 7){
			  return false;
		  }
		  //check de l'appartenance du pion au joueur
		  if(plateau.getCases()[coordArriveeX][coordArriveeY].getJoueur().equals(joueur) == false){
			  return false;
		  }
		  //check si le joueur mange son propre pion
		  if(plateau.getCases()[coordDepartX][coordDepartY].getJoueur().equals(plateau.getCases()[coordArriveeX][coordArriveeY].getJoueur()) == true && plateau.getCases()[coordArriveeX][coordArriveeY].estLibre() == false){
			  return false;
		  }
		  //check si le pion saute un autre pion
		  //On check la liste de déplacement du pion de la première à l'avant-dernière valeur (l'arrivée ne compte pas)
		  for (int i=0; i < (plateau.getCases()[coordDepartX][coordDepartY].getPion().getDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY)).size(); i++ ){
			 //Si la case de coordonnée X et Y provenant de l'occurence de la liste déplacement n'est pas libre, alors on revoie false
			  if (plateau.getCases()[((Coordonnee)plateau.getCases()[coordDepartX][coordDepartY].getPion().getDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY).get(i)).getX()][((Coordonnee)plateau.getCases()[coordDepartX][coordDepartY].getPion().getDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY).get(i)).getY()].estLibre() == false){
				  return false;
			  }
		  }
		  return true;
		  
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
		  
		  if (this.deplacementPossible(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY, joueur) == false){
			  return false;
		  }else{
			  if (plateau.getCases()[coordArriveeX][coordArriveeY].getPion() == null){
				  coordDepartX = coordArriveeX;
				  coordDepartY = coordArriveeY;
			  }else{
				  joueur.ajouterPionCapture(plateau.getCases()[coordArriveeX][coordArriveeY].getPion());
				  coordDepartX = coordArriveeX;
				  coordDepartY = coordArriveeY;
			  }
			  
		  }
		  return true;
		  
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
		  if ( this.joueur1.getPionsCaptures().size() == 8 || this.joueur2.getPionsCaptures().size() == 8 ){
			  return true;
		  }
		  return false;
	  }
	  
	  /** Redifinition de la méthode String toString()
	   * 
	   */
	  public String toString(){
		  String chaine = plateau.toString();
		  return chaine;
	  }
}