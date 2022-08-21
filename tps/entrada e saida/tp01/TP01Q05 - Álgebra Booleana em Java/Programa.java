import java.util.*; 
import java.io.*;
class Programa {


    public static boolean isfim(String b) {
        if(b.length() == 1) 
        return false;
        return true;
        
    } 
    public static boolean verifcador (String str) {
        str = str.replaceAll("\\s+","");
        StringBuffer buf = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            // realizar primeira operação
            if (str.charAt(i) == ')') {
                for (int j = i; j > 0; j--) {
                    // realizar operação caso not
                    if (str.charAt(j) == 't'){
                        if(str.charAt(j + 2) == '0') {
                            buf.replace(j - 2, i + 1, "1");
                        } else {
                            buf.replace(j - 2, i + 1, "0");
                        }
                        j = 0;
                    }
                    // realizar operação caso and
                    else if (str.charAt(j) == 'd') {
                        if (str.charAt(j + 2) == '0' || str.charAt(j + 4) == '0' || str.charAt(j + 6) == '0') {
                        buf.replace(j - 2, i + 1, "0");
                    }
                        else {
                        buf.replace(j - 2, i + 1, "1");
                    }
                    j = 0;
                    }
                    // realizar operação caso or
                    else if (str.charAt(j) == 'r') {
                        if (str.charAt(j + 2) == '1' || str.charAt(j + 4) == '1' || str.charAt(j + 6) == '1') {
                            buf.replace(j - 2, i + 1, "1");
                        }
                        else {
                            buf.replace(j - 2, i + 1, "0");
                        }  
                        j = 0;  
                    }
                }
                i = 0;
            }
        }
        System.out.println(buf);
        return true;
    }
    
    public static void preparo (String texto) {
        int entrada = Character.getNumericValue(texto.charAt(0));
        char[] letras = new char[entrada];
        int cut = 0;
        // contar quantas casas até começar a algerbra booleana
        while (texto.charAt(cut) != 'o' && texto.charAt(cut) != 'a' && texto.charAt(cut) != 'n') {
        cut++;
        }
        // guardar os valores de a b e c
        for (int i = 2, j = 0; i < cut; i+=2) {
            letras[j++] = texto.charAt(i);
            }
        // criar substring
        char[] sub = new char[texto.length() - (cut - 1)];
        for (int i = cut, index = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'A') {
            sub[index++] = letras[0];
            }
            else if (texto.charAt(i) == 'B') {
            sub[index++] = letras[1];
            }
            else if (texto.charAt(i) == 'C') {
            sub[index++] = letras[2]; 
            }
            else {
                sub[index++] = texto.charAt(i);
            }


        }
        verifcador(String.valueOf(sub));
    }

    public static void main (String[] args) {
         // criar scanner e gerador de numero randomico
         Scanner sc = new Scanner(System.in);
         String[] str = new String[1000];
         int y = 0; // numero de strings
        // ler palavras
        do {
            str[y] = sc.nextLine(); 
        } while (isfim(str[y++]));
        y--; //desconsiderar FIM

        for (int i = 0; i < y; i++) {
            
            preparo(str[i]);
        }
    }
}