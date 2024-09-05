import java.util.Scanner;

class Main { 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int nbArrets = sc.nextInt();

		int[] parents = new int[nbArrets];
		for (int i = 0; i < nbArrets; i ++) {
			parents[i] = sc.nextInt();
		}
		
		int nbRestaurants = sc.nextInt();
	
		int[] distancesALArret = new int[nbRestaurants];
		int[] arretDepart = new int[nbRestaurants];
		for (int i = 0; i < nbRestaurants; i ++) {
			distancesALArret[i] = sc.nextInt();
			arretDepart[i] = sc.nextInt();
		}
		
		// Pour chaque requête
		for (int i = 0; i < nbRestaurants; i ++) {
			int arretActuel = arretDepart[i];
	
			// On itère distancesALArret[i] fois pour prendre le parent de l'arret actuel, en réduisant à chaque fois la distance de 1
			for (int distance = distancesALArret[i]; distance > 0; distance --) {
				arretActuel = parents[arretActuel];
			}
	
			System.out.println(arretActuel);
		}
	
		// BONUS
	
		final int MAX_P2K = 20; // la puissance maximale est 2 puissance 20
		int[][] parents_2k = new int[MAX_P2K][nbArrets];
		// On initialise parents_2k[0] qui représente les premiers parents (2 puissance 0 = 1)
		for (int iArret = 0; iArret < nbArrets; iArret ++) {
			parents_2k[0][iArret] = parents[iArret];
		}
	
		// On itère sur chaque puissance de 2 à partir de 2 puissance 1 pour calculer sa table
		for (int iPuissance = 1; iPuissance < MAX_P2K; iPuissance ++) {
			for (int iArret = 0; iArret < nbArrets; iArret ++) {
				// Le 2 puissance iPuissance arrêt suivant est égal au 2 puissance iPuissance - 1 arrêt de l'arrêt
				// du 2 puissance iPuissance - 1 arrêt suivant de l'arrêt
				parents_2k[iPuissance][iArret] = parents_2k[iPuissance - 1][parents_2k[iPuissance - 1][iArret]];
			}
		}
	
		// Pour chaque requête
		for (int i = 0; i < nbRestaurants; i ++) {
			int arretActuel = arretDepart[i];
			int kADecomposer = distancesALArret[i];
		
			for (int iPuissance = 0; iPuissance < MAX_P2K; iPuissance ++) {
				// Si kADecomposer est impair alors la iPuissance-ème puissance est inclue dans k.
				if (kADecomposer % 2 == 1) {
					arretActuel = parents_2k[iPuissance][arretActuel];
				}
	
				// On divise kADecomposer pour passer à la puissance suivante
				kADecomposer /= 2;
			}
	
			System.out.println(arretActuel);
		}
	}
}