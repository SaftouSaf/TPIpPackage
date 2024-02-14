package IpPackage; 

public class IpPackage {

    // Les variables privées suivantes stockent les quatres octets de l'adresse IP 
    private int octet1;
    private int octet2;
    private int octet3;
    private int octet4;

    // Le constructeur suivant est utilisé pour créer un objet IpPackage. Elle contient quatre arguments int, un pour chaque octet de l'adresse IP
    private IpPackage (int var1, int var2, int var3, int var4){
        // On attribue les valeurs des arguments aux variables
        this.octet1 = var1;
        this.octet2 = var2;
        this.octet3 = var3;
        this.octet4 = var4;
    }

    // Cette méthode static crée et retourne un objet IpPackage. Elle contient quatre arguments int, un pour chaque octet de l'adresse IP
    public static IpPackage getInstance(int var0, int var1, int var2, int var3) {
        // Ce bloc try-catch vérifie si les octets sont dans l'intervalle valide (0-255)
        try {
            if (var0 > 0 && var0 < 255 && var1 > 0 && var1 < 255 && var2 > 0 && var2 < 255 && var3 > 0 && var3 < 255) {
                System.out.println("o1 = " + var0);
                System.out.println("o2 = " + var1);
                System.out.println("o3 = " + var2);
                System.out.println("o4 = " + var3);
            }
            else {
                throw new Exception();
            }
        } catch(Exception e) {
            // Si une erreur imprévue ce produit, on imprime un message d'erreur  
            System.out.println("Veuillez entrer des valeurs compris entre 0 et 255.");
            System.exit(-1);
        }
        // La ligne suivante crée et retourne un nouvel objet IpPackage avec les octets attribués
        return new IpPackage(var0, var1, var2, var3);
    }

    // Cette méthode permet de retourner l'adresse IP sous forme de string 
    public String ToString() {
        // On retourne les valeurs de chaque octets sous forme de string
        return "o1 =" + this.octet1 + " o2 = " + this.octet2 + " o3 = " + this.octet3 + " o4 = " + this.octet4; 
    }

    // Les méthodes suivantes sont des getters et retournent les valeurs de leurs varaibles correspondantes
    public int getOctet1() {
        return this.octet1;
    }
  
    public int getOctet2() {
        return this.octet2;
    }
  
    public int getOctet3() {
        return this.octet3;
    }
  
    public int getOctet4() {
        return this.octet4;
    }

    // Cette méthode publique detérmine la classe de l'adresse IP à partir de la valeur du premier octet
    public char getClasse() {
        // Cette variable de type char ne contiendra qu'un seul caractère et permettra de stocker la classe de l'adresse IP
        char var1 = 'x';
        
        // On utilise des conditions pour vérifier à quelle classe correspond l'adresse IP à partir de la valeur du premier octet 
        if (this.octet1 <= 126) {
           var1 = 'A';
        }
  
        if (this.octet1 >= 126 && this.octet1 <= 191) {
           var1 = 'B';
        }
  
        if (this.octet1 >= 192 && this.octet1 <= 223) {
           var1 = 'C';
        }
  
        // On retourne alors la classe de l'adresse IP
        return var1;
    }

    // Cette méthode calcule et retourne l'adresse réseau de l'objet IpPackage courant
    public IpPackage adresseReseau() {
        int var1 = this.octet1;
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;

        // Les boucles if vérifie la classe de l'adresse IP et assigne les valeurs appropriées aux variables
        if (this.getClasse() == 'B') {
           var2 = this.octet2;
        }
  
        if (this.getClasse() == 'C') {
           var2 = this.octet2;
           var3 = this.octet3;
        }
        
        // On retourne un nouvel objet IpPackage avec les octets de l'adresse réseau
        return new IpPackage(var1, var2, var3, var4);
    }
    
    // Cette méthode compare l'adresse réseau de l'objet courant avec celle d'un autre objet IpPackage passé en argument
    public Boolean estMemeReseau(IpPackage var1) {
        // Si tous les octets correspondent, la méthode retourne true, sinon elle retourne false
        return this.adresseReseau().octet1 == var1.adresseReseau().octet1 && this.adresseReseau().octet2 == var1.adresseReseau().octet2 && this.adresseReseau().octet3 == var1.adresseReseau().octet3;
    }
}

