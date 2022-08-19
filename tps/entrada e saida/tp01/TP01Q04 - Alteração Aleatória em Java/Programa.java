import java.util.*; 
import java.util.Random;
import java.lang.Math;

class Programa {
    
    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
    } 

    public static void troca(String texto, char n1, char n2) {
        char[] rand = new char[texto.length()];
    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) == n1) {
            rand[i] = n2;
        }
        else {
            rand[i] = texto.charAt(i);
        }
    }
    String str = String.valueOf(rand);
    System.out.println(str);
    }



    public static void main (String[] args) {
        // criar scanner e gerador de numero randomico
        Scanner sc = new Scanner(System.in);
        String[] str = new String[1000];
        Random gerador = new Random();
        gerador.setSeed(4);
        char n1 = '\0';
        char n2 = '\0';
        int y = 0; // numero de strings
        // ler palavras
        do {
            str[y] = sc.nextLine(); 
        } while (isfim(str[y++]));
        y--; //desconsiderar FIM
   
        for (int i = 0; i < y; i++) {
        n1 = (char) ('a' + (Math.abs(gerador.nextInt()% 26)));
        n2 = (char) ('a' + (Math.abs(gerador.nextInt()% 26)));
        troca(str[i], n1, n2);
    }
}
}