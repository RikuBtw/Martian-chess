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
		for (int i = 0; i<= tailleHorizontale; i++){
			for (int j = 0; j<= tailleVerticale/2; j++){
				this.plateau[i][j].setJoueur(joueur1);
			}
		}
		for (int i = 0; i<= tailleHorizontale; i++){
			for (int j = (tailleVerticale/2)+1; j<= tailleVerticale; j++){
				this.plateau[i][j].setJoueur(joueur2);
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
		this.plateau[7][7].setPion(new GrandPion());
		this.plateau[6][7].setPion(new GrandPion());
		this.plateau[7][6].setPion(new GrandPion());
		this.plateau[5][7].setPion(new MoyenPion());
		this.plateau[6][6].setPion(new MoyenPion());
		this.plateau[7][5].setPion(new MoyenPion());
		this.plateau[5][6].setPion(new PetitPion());
		this.plateau[4][4].setPion(new PetitPion());
		this.plateau[6][5].setPion(new PetitPion());
	}

	/** Redéfinition de la méthode String toString()
	 * 
	 */
	public String toString(){
		String chaine;
		chaine = "";
		chaine += "╔═╤═╤═╤═╗\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╠═╪═╪═╪═╣\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╟─┼─┼─┼─╢\n"
				+ "║ │ │ │ ║\n"
				+ "╚═╧═╧═╧═╝\n";
		return chaine;
	}
}
