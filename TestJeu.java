import java.util.Scanner;
/**
* Ceci est la classe TestJeu
*
* @author Julien Aubert-Béduchaud, Nicolas Bourges
* @version 1.0
*/
public class TestJeu {
	
	public static Scanner input = new Scanner(System.in);
	public static void main(String [ ] args){
		
		Joueur joueur1;
		Joueur joueur2;
		System.out.println("Entrez le pseudo du premier joueur");
		String nom = input.nextLine();
		joueur1 = new Joueur(nom);
		System.out.println("Entrez le pseudo du deuxième joueur");
		//On vérifie si les pseudos sont similaires
		do{
			nom = input.nextLine();
			joueur2 = new Joueur(nom);
			if (joueur2.equals(joueur1)){
				System.out.println("Les pseudos doivent être différents, entrez à nouveau le pseudo du deuxième joueur");
			}
		}
		while (joueur2.equals(joueur1) == true);
		//On initialise le jeu
		Jeu jeu = new Jeu(joueur1, joueur2);
		jeu.initialiserPlateau();
		//On l'affiche
		System.out.print(jeu.toString());
		//On initialise les inputs de coordonnées
		int departX, departY, arriveeX, arriveeY;
		//Tant que le jeu n'est pas fini, on demande les déplacements
		do{
			//Le premier joueur joue jusqu'à un déplacement correct
			do{
				System.out.print("\nJoueur : " + joueur1.getPseudo() + "\n" + "Coordonnee depart X: ");
				departX = input.nextInt();
				System.out.print("Coordonnee depart y: ");
				departY = input.nextInt();
				System.out.print("Coordonnee arrivée x: ");
				arriveeX = input.nextInt();
				System.out.print("Coordonnee arrivée y: ");
				arriveeY = input.nextInt();
			}while(jeu.deplacer(departX, departY, arriveeX, arriveeY, joueur1) == false);
			//On affiche le plateau après le déplacement
			System.out.print(jeu.toString());
			//Si la partie se termine durant ce tour, on stoppe la boucle
			if (jeu.arretPartie() == true){
				break;
			}
			//Le second joueur joue jusqu'à un déplacement correct
			do{
				System.out.print("\nJoueur : " + joueur2.getPseudo() + "\n" + "Coordonnee depart X: ");
				departX = input.nextInt();
				System.out.print("Coordonnee depart y: ");
				departY = input.nextInt();
				System.out.print("Coordonnee arrivée x: ");
				arriveeX = input.nextInt();
				System.out.print("Coordonnee arrivée y: ");
				arriveeY = input.nextInt();
			}while(jeu.deplacer(departX, departY, arriveeX, arriveeY, joueur2) == false);
			//On affiche le plateau après déplacement
			System.out.print(jeu.toString());
		}while (jeu.arretPartie() == false);
		//On affiche le vainqueur
		System.out.print("Partie terminée ! Vainqueur: " + jeu.joueurVainqueur().getPseudo());
		input.close();
	}

}