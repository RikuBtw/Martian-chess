import Liste.Liste;
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
	  private Coordonnee pionBloque = null;

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
		  
		  this.plateau = new Plateau(4,8);
		  this.plateau.initialiser();
		  for (int i = 0; i < this.plateau.getTailleHorizontale(); i++){
			  for (int j = 0; j < this.plateau.getTailleVerticale()/2; j++){
				  this.plateau.getCases()[i][j].setJoueur(joueur1);
			  }
		  }
		  for (int i = 0; i < this.plateau.getTailleHorizontale(); i++){
			  for (int j = this.plateau.getTailleVerticale()/2; j < this.plateau.getTailleVerticale(); j++){
				  this.plateau.getCases()[i][j].setJoueur(joueur2);
			  }
		  }
	  }
	  
	  /**Méthode qui sera appelée par le programme principal pour faire jouer un joueur
	   */
	  public void Jouer(Joueur joueur){
		  //Nous n'avons pas compris cette méthode
	  }
	  
	  /**Méthode permettant d'initialiser les joueurs
	   */
	  public void initialiserJoueur(){
		  //Nous n'avons pas compris cette méthode
	  }
  
	  /** Teste les préconditions relatives au déplacement d'un pion dans la grille de jeu
	      Des préconditions sont à vérifier:
	      Le mouvement doit être disponible.
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
		  if(coordDepartX < 0 || coordDepartX > 3 || coordDepartY < 0 || coordDepartY > 7){
			  System.out.println("│Le pion choisi n'est pas dans l'espace de jeu");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  
		  //check des coordonnées d'arrivée
		  if(coordArriveeX < 0 || coordArriveeX > 3 || coordArriveeY < 0 || coordArriveeY > 7){
			  System.out.println("│La case d'arrivée n'est pas dans l'espace de jeu");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  
		  //variables permettant d'alléger le code des lignes suivantes
		  int i = 0;
		  Case raccourciCaseD = this.plateau.getCases()[coordDepartX][coordDepartY];
		  Case raccourciCaseA = this.plateau.getCases()[coordArriveeX][coordArriveeY];

		  //check de l'existence du pion
		  if(raccourciCaseD.getPion() == null){
			  System.out.println("│Veuillez déplacer un pion");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  //check de l'appartenance du pion au joueur
		  if(raccourciCaseD.getJoueur().equals(joueur) == false){
			  System.out.println("│Ce pion ne vous appartient pas");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  
		  //check si le joueur mange son propre pion
		  if(raccourciCaseD.equals(raccourciCaseA) == true && raccourciCaseA.estLibre() == false){
			  System.out.println("│Vous ne pouvez pas capturer votre propre pion");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  //variables permettant d'alléger le code des lignes suivantes
		  Liste raccourciDeplacementD = raccourciCaseD.getPion().getDeplacement(coordDepartX,coordDepartY,coordArriveeX,coordArriveeY);
		  Coordonnee RGetI = ((Coordonnee)raccourciDeplacementD.get(i));
		  
		  //check si le pion saute un autre pion
		  if (raccourciDeplacementD.size() > 1){
			  //On check la liste de déplacement du pion de la première à l'avant-dernière valeur (l'arrivée ne compte pas)
			  for (i=0; i < raccourciDeplacementD.size(); i++ ){
				 //Si la case de coordonnée X et Y provenant de l'occurence de la liste déplacement n'est pas libre, alors on revoie false
				  if (this.plateau.getCases()[RGetI.getX()][RGetI.getY()].estLibre() == false){
					  System.out.println("│Impossible de sauter un autre pion");
					  System.out.println("╘═════════════════════════");
					  return false;
				  }
			  }
		  }
		  //check si le déplacement est disponible.
		  if (raccourciDeplacementD.size() == 0) {
			  System.out.println("│Ce mouvement est impossible.");
			  System.out.println("╘═════════════════════════");
			  return false;
		  }
		  
		  //check pour ne pas renvoyer un pion dans son camp après son arrivée, pion déterminé dans la fonction déplacer
		  if (this.pionBloque != null){
			  if (this.pionBloque.getX() == coordDepartX && this.pionBloque.getY() == coordDepartY){
				  System.out.println("│Vous ne pouvez pas déplacer ce pion tout de suite.");
				  System.out.println("╘═════════════════════════");
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
		  
		  //Si le déplacement est impossible, on renvoie que le déplacement n'a pas eu lieu, sinon on continue le déplacement
		  if (this.deplacementPossible(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY, joueur) == false){
			  return false;
		  }else{
			  //On stocke le pion déplacé dans une variable temporaire et on le supprime du plateau
			  Pion pionDeplace = this.plateau.getCases()[coordDepartX][coordDepartY].getPion();
			  this.plateau.getCases()[coordDepartX][coordDepartY].setPion(null);
			  
			  //Si il y a un pion sur l'arrivée, on le capture et on place le pion, sinon on place juste le pion
			  if (this.plateau.getCases()[coordArriveeX][coordArriveeY].estLibre() == false){
				  joueur.ajouterPionCapture(this.plateau.getCases()[coordArriveeX][coordArriveeY].getPion());
				  this.plateau.getCases()[coordDepartX][coordDepartY].setPion(null);
				  this.plateau.getCases()[coordArriveeX][coordArriveeY].setPion(pionDeplace);
			  }else{
				  this.plateau.getCases()[coordArriveeX][coordArriveeY].setPion(pionDeplace);
			  }
			  
			  //On regarde si le pion a changé de camp
			  if (this.plateau.getCases()[coordDepartX][coordDepartY].getJoueur().equals(this.plateau.getCases()[coordArriveeX][coordArriveeY].getJoueur()) == false){
				  //Si oui, on redéfini les coordonnées du pion
				  this.pionBloque = new Coordonnee(coordArriveeX, coordArriveeY);
			  }else{
				  //Sinon, on passe la valeur à null
				  this.pionBloque = null;
			  }
			  
			  
		  }
		  return true;
		  
	  }

	  /** Donne le joueur gagnant
	   * 
	   * @return Le joueur gagnant ou null si les 2 joueurs sont ex aequo
	   */
	  public Joueur joueurVainqueur(){
		  Joueur gagne = null;
		  if (this.joueur1.calculerScore() < this.joueur2.calculerScore()){
			  gagne = joueur2;
		  }else if (this.joueur1.calculerScore() > this.joueur2.calculerScore()){
			  gagne = joueur1;
		  }else if (this.joueur1.calculerScore() == this.joueur2.calculerScore()){
			  gagne = null;
		  }
		  return gagne;
	  }
	  
	  /** Permet de savoir si la partie est finie ou non
	   * 
	   * @return true si la partie est finie, false sinon
	   */
	  public boolean arretPartie(){
		  
		  int jouerJ1 = 0;
		  Coordonnee pionDeplacableJ1 = null;
		  int jouerJ2 = 0;
		  Coordonnee pionDeplacableJ2 = null;
		  
		  //On cherche le nombre de pions que J1 peut déplacer, on stocke les coordonnées du dernier trouvé pour les utiliser si il ne lui reste qu'un pion
		  for (int i = 0; i < this.plateau.getTailleHorizontale(); i++){
				for (int j = 0; j < this.plateau.getTailleVerticale()/2; j++){
					if (this.plateau.getCases()[i][j].estLibre() == false){
						jouerJ1 ++;
						pionDeplacableJ1 = new Coordonnee(i,j);
					}
				}
		  }
		  //On cherche le nombre de pions que J2 peut déplacer, on stocke les coordonnées du dernier trouvé pour les utiliser si il ne lui reste qu'un pion
		  for (int i = 0; i < this.plateau.getTailleHorizontale(); i++){
				for (int j = this.plateau.getTailleVerticale()/2; j < this.plateau.getTailleVerticale(); j++){
					if (this.plateau.getCases()[i][j].estLibre() == false){
						jouerJ2 ++;
						pionDeplacableJ2 = new Coordonnee(i,j);
					}
				}
		  }
		  //Si le seul pion déplacable de J1 est celui qu'il vient d'entrer dans le camp ennemi, alors J1 ne peut rien déplacer
		  if (jouerJ1 == 1 && this.pionBloque != null){
			  if (this.pionBloque.getX() == pionDeplacableJ1.getX() && pionBloque.getY() == pionDeplacableJ1.getY()){
				  pionDeplacableJ1 = null;
				  jouerJ1 = 0;
			  }
		  }
		  //Si le seul pion déplacable de J2 est celui qu'il vient d'entrer dans le camp ennemi, alors J2 ne peut rien déplacer
		  if (jouerJ2 == 1 && this.pionBloque != null){
			  if (this.pionBloque.getX() == pionDeplacableJ2.getX() && this.pionBloque.getY() == pionDeplacableJ2.getY()){
				  pionDeplacableJ2 = null;
				  jouerJ2 = 0;
			  }
		  }
		  //Si aucun pion n'est déplacable, on retourne true, sinon false
		  if (jouerJ1 == 0 && jouerJ2 == 0){
			  return true;
		  }
		  if (jouerJ1 == 1 && jouerJ2 == 0){
			  return true;
		  }
		  if (jouerJ1 == 0 && jouerJ2 == 1){
			  return true;
		  }
		  return false;
	  }
	  
	  /** Redifinition de la méthode String toString()
	   * 
	   */
	  public String toString(){
		  String chaine = "\n│ Joueur " + this.joueur1.getPseudo() + " : " + this.joueur1.calculerScore()+"\n";
		  chaine += "└──────────────────";
		  chaine += this.plateau.toString();
		  chaine += "┌──────────────────";
		  chaine += "\n│ Joueur " + this.joueur2.getPseudo() + " : " + this.joueur2.calculerScore() +"\n";
		  return chaine;
	  }
}