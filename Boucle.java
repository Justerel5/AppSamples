package Main;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


// TODO Double Boucle while
public class Exo1 {
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
  String prenom;
  char reponse = ' ';
  
  do {
    System.out.println("Donnez un prénom : ");
    prenom = sc.nextLine();
    System.out.println("Bonjour " + prenom + ", comment vas-tu ?");
    do {
      System.out.println("Voulez-vous réessayer ? (O/N)");
      reponse = sc.nextLine().charAt(0); // On récupère la réponse de l'utilisateur
    } while (reponse != 'O' && reponse != 'N');
  } while (reponse == 'O');
  
  System.out.println("Au revoir...");
  }
}


// TODO Multiplier un caractère
public class Exo2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int chiffre = 0;
				
		System.out.println("Saississez votre chiffre : ");
		chiffre = sc.nextInt();
		String str = "";
		char val = '*';
		System.out.println("N = " + chiffre);
			
		char[] c = {};
			
		for (int i = chiffre; i <= chiffre && i >= 1; i--) {
			c = new char[i];
			Arrays.fill(c, val);
			str = new String(c);
			System.out.println(str); // Fonction java str.repeat(i) en déclarant String str = new String("*");
		}
	}
}


//TODO Multiplier un caractère	
public class Exo3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saississez votre chiffre : ");
		
		int chiffre = sc.nextInt(), rep = 0;
		
		do {
			System.out.println("Veuillez saisir un chiffre compris entre 1 et 4\n");
			System.out.println("1. Ajouter 1");
			System.out.println("2. Multiplier par 2");
			System.out.println("3. Soustraire 4");
			System.out.println("4. Quitter");
			
			rep = sc.nextInt();
		} while (rep < 1 || rep > 4);
		
		switch (rep) {
		case 1:
			System.out.println(ajouter(chiffre));
			break;
		case 2:
			System.out.println(multiplier(chiffre));
			break;
		case 3:
			System.out.println(soustraire(chiffre));
			break;
			default:
			System.exit(0);
		}
	}
	

	public static int ajouter(int nbre) {
		return nbre + 1;
	}
	
	public static int multiplier(int nbre) {
		return nbre * 2;
	}
	
	public static int soustraire(int nbre) {
		return nbre - 4;
	}
}	


//TODO Gestion des notes d'un élève
public class Exo4 {
	
	public static void main(String[] args) {
			
		String nom = "", prenom = "";
		String dateNais[] = new String[3];
		int nbreNotes = 0, pos = 0;
		Scanner sc = new Scanner(System.in);
			
		// On récupère les informations de l'utilisateur
		System.out.print("Veuillez saisir le nom : ");
		nom = sc.nextLine();
		System.out.print("Veuillez saisir le prénom : ");
		prenom = sc.nextLine();
		System.out.print("Veuillez saisir la date de naissance : \nJour : ");
		dateNais[0] = sc.nextLine();
		System.out.print("Mois : ");
		dateNais[1] = sc.nextLine();
		System.out.print("Année : ");
		dateNais[2] = sc.nextLine();
		System.out.println("Veuillez saisir le nombre de notes : ");
		nbreNotes = sc.nextInt();
		double notes[] = new double[nbreNotes];
			
		for (int i = 0, j = 1; i < notes.length; i++, j++) {
			if (j == 1) {
				System.out.print(j + "ère note : ");
				notes[i] = sc.nextDouble();
			} else {
				System.out.print(j + "ème note : ");
				notes[i] = sc.nextDouble();
			}
		}
			
			
		// Affiche le résultat prévu
		System.out.println("==============================\nEtudiant");
		System.out.println("==============================");
		System.out.println("Nom : " +nom.toUpperCase());
		System.out.println("Prénom : " +prenom);
		System.out.println("Né(e) le : " +dateNais[0]+ "-" +dateNais[1]+ "-" +dateNais[2]);
		System.out.println("Nombre de notes : " +nbreNotes);
		
		String str = "", stri = "", s = "", st = "";
		
		for (int i = 0, j = notes.length-1; i < notes.length && j >= 0; i++, j--) {
			if (j != 0)
				str += notes[i]+ ", ";
			else
				stri += notes[i];
		}
		System.out.println("Notes : " +str+ "" +stri);
		System.out.println("Moyenne : " +moyenne(notes));
		System.out.println("Note Maxi : " +noteMaxi(notes));
		System.out.println("Note Mini : " +noteMini(notes));
		System.out.println("==============================");
		
	 	System.out.println("Veuillez saisir la position de la note à afficher : ");
	 	pos = sc.nextInt();
	 	
	 	lireNote(notes, pos);
	 	
	 	System.out.println("Veuillez saisir la position de la note à supprimer : ");
	 	pos = sc.nextInt();
	 	
	 	notes = enleverNote(notes, pos);
	 	for (int i = 0, j = notes.length-1; i < notes.length && j >= 0; i++, j--) {
			if (j != 0)
				s += notes[i]+ ", ";
			else
				st += notes[i];
		}
		System.out.println("Notes : " +s+ "" +st);
	}
		

	public static double[] enleverNote(double notes[], int pos) {
		double[] nvNotes = {};		
		if (pos < 0 || pos >= notes.length) {
			System.out.println("Index invalide.");
			return notes;
		} else if (notes.length > 0) {
			nvNotes = new double[notes.length -1];
			int j = 0;
			for (int k = 0; k < notes.length; k++) {
				if (k == pos-1)
					continue;
					
				nvNotes[j++] = notes[k];
			}
			System.out.println("La note à la position n°" +pos+ " a été supprimée.");
			
			return nvNotes;
		} else {
			System.out.println("Il ne reste plus qu'une note, impossible de la supprimer.");
		}
		return nvNotes;
	}
		
		
	public static double noteMini(double notes[]) {
		double min = notes[0]; // On suppose que le premier nombre est le plus petit
		for (int i = 1; i < notes.length; i++) { // 2. On parcourt le tableau à partir du deuxième élément
			if (notes[i] < min)
				min = notes[i]; // 3. On met à jour min si on trouve le plus petit
		}
		return min;
	}
		
	public static double noteMaxi(double notes[]) {
		double max = notes[0]; // On suppose que le premier nombre est le plus grand
		for (int i = 1; i < notes.length; i++) { // 2. On parcourt le tableau à partir du deuxième élément
			if (notes[i] > max)
				max = notes[i]; // 3. On met à jour max si on trouve le plus grand
		}
		return max;
	}
		
	public static void lireNote(double notes[], int pos) {
		System.out.println("La position n°" +pos+ " correspond à la note : " +(notes[pos-1]));
	}
		
	public static double moyenne(double notes[]) {
		double som = 0.0, moy = 0.0;
		for (int i = 0; i < notes.length; i++) {
			som += notes[i];
		}
		moy = som / (double)notes.length;
		return moy;
	}
}	
	

//TODO Ecrire dans un ficher
public class Exo5 {
		
	public static void main(String[] args) {
		try {
			File f = new File("D:/Projets/Java/fiche.txt");
		  // Création d'un fileWriter pour écrire dans un fichier
		  FileWriter fileWriter = new FileWriter(f, false);
		    
		  // Création d'un bufferedWriter qui utilise le fileWriter
		  BufferedWriter writer = new BufferedWriter(fileWriter);

		  // ajout d'un texte à notre fichier
		  writer.write("preferenceNewsletter=false");

		  // Retour à la ligne
		  writer.newLine();

		  writer.write("preferenceColor=#425384");
		  writer.close();
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}
}


//TODO Lire un ficher	
public class Exo6 {
		
	public static void main(String[] args) {
		try {
		  // Création d'un fileReader pour lire le fichier
			FileReader fileReader = new FileReader("D:/Projets/Java/fiche.txt");

			// Création d'un bufferedReader qui utilise le fileReader
		  BufferedReader reader = new BufferedReader(fileReader);
		            
		  // une fonction à essayer pouvant générer une erreur
		  String line = reader.readLine();
		            
		  while (line != null) {
		  	// affichage de la ligne
		    System.out.println(line);

		    // lecture de la prochaine ligne
		    line = reader.readLine();
		  }
		  reader.close();
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}
}


//TODO Chiffre en lettres	(Français)
public class Exo7 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nombre;
		char rep = ' '; // Character c = null;
			
		// On récupère les informations de l'utilisateur
		do {	
			System.out.println("Veuillez saisir un nombre entier compris entre 0 et 9999 : ");
			
			try {
					nombre = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage() + " n'est pas un nombre entier compris entre ");
			}
			
			num2Letters(nombre);
			do {
				System.out.println("Voulez-vous recommencer (O/N) ?");
				sc.nextLine(); // On vide la saisie de l'utilisateur pour changer le type de récupération de la variable
				rep = sc.nextLine().charAt(0);
				// c = Character.toUpperCase(rep); -> Pour écrire le caractère en majuscule si ce n'est pas le cas
			} while (rep != 'O' && rep != 'N'); // A la place de [rep] on remplace [c]
		} while (rep == 'O');
		
		System.out.println("Au revoir...");
	}
			
	public static String num2Letters(int nombre) {
		String unitsOut = "", tensOut = "", hundredsOut = "", thousandsOut = "", num2Letters = "";
		int units = 0, tens = 0, hundreds = 0, thousands = 0;
			
		if (nombre < 0 || nombre > 9999) {
			System.out.println("Veuillez entrer un nombre entier compris entre 0 et 9999.");
		}
			
		String[] units2Letters = {"", "un", "deux", "trois", "quatre",
			"cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze",
			"treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf"},
			
		tens2Letters = {"", "dix", "vingt", "trente", "quarante", "cinquante",
			"soixante", "soixante", "quatre-vingt", "quatre-vingt"};
			
		units = nombre % 10;
		tens = (nombre % 100 - units) / 10;
		hundreds = (nombre % 1000 - nombre % 100) / 100;
		thousands = (nombre % 10000 - nombre % 1000) / 1000;
			
		if (nombre == 0) 
			return "zero";
		else {
			// Traitement des unités
			unitsOut = (units == 1 && tens > 0 && tens != 8 ? "et-" : "") + units2Letters[units];
				
			// Traitement des dizaines
			if (tens == 1 && units > 0) {
			tensOut = units2Letters[10 + units];
			unitsOut = "";
			} else if (tens == 7 || tens == 9) {
			tensOut = tens2Letters[tens] + "-" + (tens == 7 && units == 1 ? "et-" : "") + units2Letters[10 + units];
			unitsOut = "";
			} else {
				tensOut = tens2Letters[tens];
			}
				
			tensOut += (units == 0 && tens == 8 ? "s" : "");
				
			// Traitement des centaines
			hundredsOut = (hundreds > 1 ? units2Letters[hundreds] + "-" : "")
					+ (hundreds > 0 ? "cent" : "")
					+ (hundreds > 1 && tens == 0 && units == 0 ? "s" : "");
				
			// Traitement des milliers
			thousandsOut = (thousands > 1 ? units2Letters[thousands] + "-" : "")
					+ (thousands > 0 ? "mille" : "");
				
			// Retour du total
			num2Letters = thousandsOut + (!thousandsOut.isEmpty() && !hundredsOut.isEmpty() || !thousandsOut.isEmpty() && !tensOut.isEmpty() || !thousandsOut.isEmpty() && !unitsOut.isEmpty() ? "-" : "")
					+ hundredsOut + (!hundredsOut.isEmpty() && !tensOut.isEmpty() || !hundredsOut.isEmpty() && !unitsOut.isEmpty() ? "-" : "")
					+ tensOut + (!tensOut.isEmpty() && !unitsOut.isEmpty() ? "-" : "")
					+ unitsOut;	
				
			System.out.println(num2Letters);
			
			return num2Letters;
		}
	}
	
	//TODO Chiffre en lettres	(Anglais)
	/*public static void main(String[] args) {
		
		//Test
		
		Scanner sc = new Scanner(System.in);
		int nombre;
		char rep = ' ';
			
		// On récupère les informations de l'utilisateur
		do {	
			System.out.println("Enter a number between 0 and 9999: ");
			nombre = sc.nextInt();
			num2Letters(nombre);
			do {
				System.out.println("Would you like to restart (Y/N)?");
				sc.nextLine(); // On vide la saisie de l'utilisateur pour changer le type de récupération de la variable
				rep = sc.nextLine().charAt(0);
			} while (rep != 'Y' && rep != 'N');
		} while (rep == 'Y');
	}
		
	
	public static String num2Letters(int nombre) {
		String unitsOut = "", tensOut = "", hundredsOut = "", thousandsOut = "", num2Letters = "", masjuscule = "";
		int units = 0, tens = 0, hundreds = 0, thousands = 0;
		

		if (nombre < 0 || nombre > 9999) {
			System.out.println("Enter a number between 0 and 9999.");
		}
		
		String[] units2Letters = {"", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
		
		tens2Letters = {"", "ten", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety"};
		
		units = nombre % 10;
		tens = (nombre % 100 - units) / 10;
		hundreds = (nombre % 1000 - nombre % 100) / 100;
		thousands = (nombre % 10000 - nombre % 1000) / 1000;
		
		
		if (nombre == 0)
			return "zero";
		else {
			// Traitement des unités
			unitsOut = units2Letters[units];
			
			// Traitement des dizaines
			if (tens == 1 && units > 0) {
			tensOut = units2Letters[10 + units];
			unitsOut = "";
			} else {
				tensOut = tens2Letters[tens];
			}
			
			// Traitement des centaines
			hundredsOut = (hundreds > 0 ? units2Letters[hundreds] + " " : "")
					+ (hundreds > 0 ? "hundred" : "")
					+ (hundreds > 0 && tens > 0 && units >= 0 || hundreds > 0 && tens == 0 && units > 0 ? " and" : "");
			
			// Traitement des milliers
			thousandsOut = (thousands > 0 ? units2Letters[thousands] + " " : "")
					+ (thousands > 0 ? "thousand" : "")
					+	(thousands > 0 && hundreds >= 0 ? "" : (thousands > 0 && tens > 0 && units >= 0 || thousands > 0 && tens == 0 && units > 0 ? " and" : ""));
			
			// Retour du total
			num2Letters = thousandsOut + (!thousandsOut.isEmpty() && !hundredsOut.isEmpty() || !thousandsOut.isEmpty() && !tensOut.isEmpty() || !thousandsOut.isEmpty() && !unitsOut.isEmpty() ? " " : "")
					+ hundredsOut + (!hundredsOut.isEmpty() && !tensOut.isEmpty() || !hundredsOut.isEmpty() && !unitsOut.isEmpty() ? " " : "")
					+ tensOut + (!tensOut.isEmpty() && !unitsOut.isEmpty() ? "-" : "")
					+ unitsOut;
			
			// Récupération de la première lettre 
			masjuscule = num2Letters.substring(0, 1);
			
			System.out.println(masjuscule.toUpperCase() + num2Letters.substring(1));
			
			return num2Letters;
		}
	}*/
}


public class Exo8 {
	
	public static void main(String[] main) {
		System.out.println("Star Wars");
	}
	
	public static String categorieDeFilm(final String film) {
    var resultat = switch (film) {
    case "Star Wars" -> "Science fiction";
    case "Blanche neige", "La petite sirène" -> "Disney";
    case "Indiana Jones" -> { 
    	String categorie = "Aventure";
      yield categorie;
      }
    default -> "Inconnu";
    };
    return resultat;
  }
}


public class Exo9 {
	class Boucle {
		public static void main(String[] args) {
			
			// Boucle "For" avec saut de valeur
			for ( int i = 0; i < 10; i++) {
			// déclarations exécutées à chaque itération
				if (i == 2 || i == 5) {
					continue;
			  }
			System.out.println("Valeur de i : " + i + ".");
			}
			
			// Boucle "While"
			int pushUpGoal = 0;
			while(pushUpGoal > 0) {
				System.out.println("Push up!");
				pushUpGoal -= 1;
			} // Boucle infinie

			// Boucle "do/while"
			int pushUpGoal2 = 0;
			do {
			  System.out.println("Push up!");
			  pushUpGoal2 -= 1;
			} while (pushUpGoal2 > 0); // S'exécute une fois seulement
	}


	class Tableau {
		public static void main(String[] args) {
			int myArray[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		
		
			for (int i = 0; i < myArray.length ; i++) {
				if (myArray[i] == 50) {
					System.out.println("J'ai trouvé mon " +myArray[i]+ " !");
					break;
				}
				System.out.println("J'en suis à " +myArray[i]+ " ...");
			}
			
			/*
			 * 	avec la boucle "for each"
			 * 	for (int i : myArray) {
			 *		System.out.println("J'en suis à " +i+ " ...");
			 *	}
			 */
		}
	}
}