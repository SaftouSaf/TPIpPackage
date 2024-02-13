import IpPackage.*;
import java.util.Scanner;
class IpTest {
	public static void main(String args[]) {
		// on utilise un scanner pour demander à l'utilisateur d'entrer les adresses IP
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le premier octet de la première adresse IP: ");
		int o1 = sc.nextInt();
		System.out.print("Entrez le deuxième octet de la première adresse IP: ");
		int o2 = sc.nextInt();
		System.out.print("Entrez le troisiéme octet de la première adresse IP: ");
		int o3 = sc.nextInt();
		System.out.print("Entrez le quatrième octet de la première adresse IP: ");
		int o4 = sc.nextInt();

		IpPackage ip1 = IpPackage.getInstance(o1, o2, o3, o4);
		System.out.println("\nLa suite: ");

		System.out.print("Entrez le premier octet de la deuxième adresse IP: ");
		int ip2o1 = sc.nextInt();
		System.out.print("Entrez le deuxième octet de la deuxième adresse IP: ");
		int ip2o2 = sc.nextInt();
		System.out.print("Entrez le troisième octet de la deuxième adresse IP: ");
		int ip2o3 = sc.nextInt();
		System.out.print("Entrez le quatrième octet de la deuxième adresse IP: ");
		int ip2o4 = sc.nextInt();
		sc.close();
		IpPackage ip2 = IpPackage.getInstance(ip2o1, ip2o2, ip2o3, ip2o4);
		System.out.println("Valeur de l'octet 4 = " + ip2.getOctet4());

		// Affichage de la classe ?
		System.out.println("Classe de l'adresse ip1  " + ip1.getClasse());
		System.out.println("Classe de l'adresse ip2  " + ip2.getClasse());
		System.out.println("\n\n");

		// Adresse réseau des deux réseaux
		System.out.println("Adresse reseau de l'adresse ip1  " + ip1.adresseReseau().ToString());
		System.out.println("Adresse reseau de l'adresse ip2  " + ip2.adresseReseau().ToString());
		System.out.println("\n\n");

		// est même réseau ?
		System.out.println("ip1 et ip2 meme reseau ? " + ip1.estMemeReseau(ip2));
	}
}
