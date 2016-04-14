/**
* Ceci est la classe Plateau
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
*@version 1.0
*/
public class Plateau{
	
	private int tailleHorizontale;
	private int tailleVerticale;
	private Case[][] plateau = new Case[tailleHorizontale][tailleVerticale];

	/** Constructeur du plateau
	 * 
	 * @param tailleHorizontale
	 * @param tailleVerticale
	 */
	public Plateau(int tailleHorizontale, int tailleVerticale){
		this.tailleHorizontale = tailleHorizontale;
		this.tailleVerticale = tailleVerticale;
	}
	
	/**Accesseur renvoyant les cases du plateau
	 * 
	 * @return plateau
	 */
	public Case[][] getCases(){
		return this.plateau;
	}
	
	/** Accesseur renvoyant la taille horizontale du plateau
	 * 
	 * @return tailleVerticale
	 */
	public int getTailleHorizontale(){
		return this.tailleHorizontale;
	}
	
	/** Accesseur renvoyant la taille verticale du plateau
	 * 
	 * @return tailleHorizontale
	 */
	public int getTailleVerticale(){
		return this.tailleVerticale;
	}
	
	/** Méthode permettant d'initialiser le plateau
	 * 
	 */
	public void initialiser(){
		//Initialisation de la taille
		this.tailleHorizontale = 4;
		this.tailleVerticale = 8;
		//Initialisation des cases du plateau
		for (int i = 0; i<= tailleHorizontale; i++){
			for (int j = 0; j<= tailleVerticale; j++){
				this.plateau[i][j] = new Case();
			}
		}
		//Emplacement des pions par défaut
		//Partie Haute
		this.plateau[0][0].setPion(new GrandPion());
		this.plateau[1][0].setPion(new GrandPion());
		this.plateau[0][1].setPion(new GrandPion());
		this.plateau[2][0].setPion(new MoyenPion());
		this.plateau[1][1].setPion(new MoyenPion());
		this.plateau[0][2].setPion(new MoyenPion());
		this.plateau[2][1].setPion(new PetitPion());
		this.plateau[3][3].setPion(new PetitPion());
		this.plateau[1][2].setPion(new PetitPion());
		//Partie Basse
		this.plateau[3][7].setPion(new GrandPion());
		this.plateau[2][7].setPion(new GrandPion());
		this.plateau[3][6].setPion(new GrandPion());
		this.plateau[1][7].setPion(new MoyenPion());
		this.plateau[2][6].setPion(new MoyenPion());
		this.plateau[3][5].setPion(new MoyenPion());
		this.plateau[1][6].setPion(new PetitPion());
		this.plateau[1][5].setPion(new PetitPion());
		this.plateau[2][5].setPion(new PetitPion());
	}

	/** Redéfinition de la méthode String toString()
	 * 
	 */
	public String toString(){
		String chaine;
		chaine = "";
		chaine += "╔═╤═╤═╤═╗\n";
		for (int i = 0; i<= tailleHorizontale; i++){
			for (int j = 0; j<= tailleVerticale; j++){ 
				if (plateau[i][j] == null && i == 0){
					chaine += "║ ";
				}else if (plateau[i][j].getPion() == null && i == 3){
					chaine += "│ ║\n";
					chaine += "╟─┼─┼─┼─╢\n";
				}else if (plateau[i][j].getPion() == null && i == 3 && j ==3){
					chaine += "│ ║\n";
					chaine += "╠═╪═╪═╪═╣\n";
				}else if (plateau[i][j].getPion() == null && i == 3 && j ==7){
					chaine += "│ ║\n";
					chaine += "╚═╧═╧═╧═╝\n";
				}else if (plateau[i][j].getPion() != null && i == 3){
					chaine += plateau[i][j].getPion().toString() +"║\n";
					chaine += "╟─┼─┼─┼─╢\n";
				}else if (plateau[i][j].getPion() == null && i == 3 && j ==3){
					chaine += plateau[i][j].getPion().toString() +"║\n";
					chaine += "╠═╪═╪═╪═╣\n";
				}else if (plateau[i][j].getPion() == null && i == 3 && j ==7){
					chaine += plateau[i][j].getPion().toString() +"║\n";
					chaine += "╚═╧═╧═╧═╝\n";
				}else if (plateau[i][j].getPion() != null){
					chaine += plateau[i][j].getPion().toString();	
				}else{
					chaine = "│ ";
				}	
			}
		}
		return chaine;
	}
}
