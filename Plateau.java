/**
* Ceci est la classe Plateau
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
*/
public class Plateau{
	
	private int tailleHorizontale;
	private int tailleVerticale;
	private Case plateau[][];

	/** Constructeur du plateau
	 * 
	 * @param tailleHorizontale
	 * @param tailleVerticale
	 */
	public Plateau(int saTailleHorizontale, int saTailleVerticale){
		this.tailleHorizontale = saTailleHorizontale;
		this.tailleVerticale = saTailleVerticale;
		this.plateau = new Case[this.tailleHorizontale][this.tailleVerticale];
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
		//Initialisation des cases du plateau
		for (int i = 0; i < tailleHorizontale; i++){
			for (int j = 0; j < tailleVerticale; j++){
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
		this.plateau[2][2].setPion(new PetitPion());
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
		String chaine = "";
		chaine += "╔═╤═╤═╤═╗ \n";
			for (int j=0; j < tailleVerticale; j++){
				chaine += "║";
				for (int i=0; i < tailleHorizontale; i++){
					if (plateau[i][j].getPion() == null){
						chaine +=" ";
					}else{				
						chaine += plateau[i][j].getPion().toString(); 
					}
					if (i != 3){
						chaine += "│";
					}else{
						chaine += "║";
					}
				}
				if (j == 7){
					chaine += "\n╚═╧═╧═╧═╝ \n";
				}else if (j == 3){
					chaine += "\n╠═╪═╪═╪═╣ \n";
				}else{
					chaine += "\n╟─┼─┼─┼─╢ \n";
				}
			}
			return chaine;
	}
}
