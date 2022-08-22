import java.util.*; 

class Programa {

    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    }

    public static void is(String texto) {
    texto.toLowerCase();
    System.out.print(isVogal(texto)  + " ");
    System.out.print(isconsu(texto)  + " ");
    System.out.print(isint(texto)  + " ");
    System.out.println(isreal(texto));
    }

    public static String isVogal(String texto) {
     for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u') {
            return ("NAO");
        }
     }
     return ("SIM");
    }

    public static String isconsu(String texto) {
        for (int i = 0; i < texto.length(); i++) {
           if (!(texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') || (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u')) {
               return ("NAO");
           }
        }
        return ("SIM");
       }

    public static String isint(String texto) {
        for (int i = 0; i < texto.length(); i++) {
           if (!(texto.charAt(i) >= '0' && texto.charAt(i) <= '9')) {
            return ("NAO");
           }
        }
        return ("SIM");
       }
       
       public static String isreal(String texto) {
        int count = 0;
        for (int i = 0; i < texto.length(); i++) {
           if (!(((texto.charAt(i) >= '0' && texto.charAt(i) <= '9') || texto.charAt(i) == ',' || texto.charAt(i) == '.') && count < 2)) {
            return ("NAO");
           }
           if (texto.charAt(i) == ',' || texto.charAt(i) == '.') {
            count++;
           }
        }

        return ("SIM");
       }     

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[1000];
        int y = 0; // numero de strings
        // ler palavras
        do {
            str[y] = sc.nextLine(); 
        } while (isfim(str[y++]));
        y--; //desconsiderar FIM

        for (int i = 0; i < y; i++) {
            is(str[i]);
            }
    }

    
}