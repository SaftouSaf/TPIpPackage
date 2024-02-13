package IpPackage; 

public class IpPackage {
    private int octet1;
    private int octet2;
    private int octet3;
    private int octet4;

    private IpPackage (int var1, int var2, int var3, int var4){
        this.octet1 = var1;
        this.octet2 = var2;
        this.octet3 = var3;
        this.octet4 = var4;
    }

    public void test() {
        System.out.println("Hello World Package OK ?");
    }

    public static IpPackage getInstance(int var0, int var1, int var2, int var3) {
        try {
            if (var0 < 0 || var0 > 255|| var1 < 0 || var1 > 255|| var2 < 0 || var2 > 255|| var3 < 0 || var3 > 255) {
                throw new Exception();
            }
        } catch(Exception e) {
            System.out.println("Erreur " + e);
        }
        System.out.println("o1 = " + var0);
        System.out.println("o2 = " + var1);
        System.out.println("o3 = " + var2);
        System.out.println("o4 = " + var3);
        return new IpPackage(var0, var1, var2, var3);
    }

    public String ToString() {
        return "o1" + this.octet1 
    }
    
}

