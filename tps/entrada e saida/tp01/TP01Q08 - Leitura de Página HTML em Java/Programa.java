import java.io.*;
import java.net.*;
import java.util.*;

class Programa {
    public static String getHtml(String endereco){
       URL url;
       InputStream is = null;
       BufferedReader br;
       String resp = "", line;
 
       try {
          url = new URL(endereco);
          is = url.openStream();  // throws an IOException
          br = new BufferedReader(new InputStreamReader(is));
 
          while ((line = br.readLine()) != null) {
             resp += line + "\n";
          }
       } catch (MalformedURLException mue) {
          mue.printStackTrace();
       } catch (IOException ioe) {
          ioe.printStackTrace();
       } 
 
       try {
          is.close();
       } catch (IOException ioe) {
          // nothing to see here
 
       }
 
       return resp;
    }

    public static void verifica (String html, String NomeDaPagina) {
     int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0; //vogais
     int x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0, x11 = 0, x12 = 0, x13 = 0, x14 = 0, x15 = 0, x16 = 0, x17 = 0, x18 = 0, x19 = 0, x20 = 0, x21 = 0, x22 = 0; //vogais com assento
     int x23 = 0; //consoante
     int x24 = 0; //<br>
     int x25 = 0; //<table>

     //verificar ocorrencias

     for (int i = 0; i < html.length(); i++) {
        // verificar vogais
        if (html.charAt(i) == 'a') {
            x1++;
        }
        else if(html.charAt(i) == 'e'){
            x2++;
        }
        else if(html.charAt(i) == 'i'){
            x3++;
        }
        else if(html.charAt(i) == 'o'){
            x4++;
        }
        else if(html.charAt(i) == 'u'){
            x5++;
        }

        //verificar ocorrencias com assento pra direita
        else if(html.charAt(i) == 'á') {
         x6++;
        }
        else if(html.charAt(i) == 'é') {
         x7++;
        }
        else if(html.charAt(i) == 'í') {
         x8++;
        }
        else if(html.charAt(i) == 'ó') {
         x9++;
        }
        else if(html.charAt(i) == 'ú') {
         x10++;
        }

        //verificar ocorrencias com assento pra esquerda
        else if(html.charAt(i) == 'à') {
         x11++;
        }
        else if(html.charAt(i) == 'è') {
         x12++;
        }
        else if(html.charAt(i) == 'ì') {
         x13++;
        }
        else if(html.charAt(i) == 'ò') {
         x14++;
        }
        else if(html.charAt(i) == 'ù') {
         x15++;
        }

        //verificar ocorrencias com assento ~
        else if(html.charAt(i) == 'ã') {
         x16++;
        }
        else if(html.charAt(i) == 'õ') {
         x17++;
        }

        // verificar ocorrencias com assento ^
        else if(html.charAt(i) == 'â') {
         x18++;
        }
        else if(html.charAt(i) == 'ê') {
         x19++;
        }
        else if(html.charAt(i) == 'î') {
         x20++;
        }
        else if(html.charAt(i) == 'ô') {
         x21++;
        }
        else if(html.charAt(i) == 'û') {
         x22++;
        }
        // verificar se Ã© consuante
        else if(html.charAt(i) >= 'b' && html.charAt(i) <= 'd' || html.charAt(i) >= 'f' && html.charAt(i) <= 'h' || html.charAt(i) >= 'j' && html.charAt(i) <= 'n' || html.charAt(i) >= 'p' && html.charAt(i) <= 't' || html.charAt(i) >= 'v' && html.charAt(i) <= 'z') {
         x23++;
        }
        // verificar presenÃ§a de tag <br> e <table>
        else if (html.charAt(i) == '<') {
        if (html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r' && html.charAt(i + 3) == '>') {
          i += 4;
         x24++;
        }
        else if (html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a' && html.charAt(i + 3) == 'b' && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e' && html.charAt(i + 6) == '>') {
          i += 7;
         x25++;
        }
     }
     
   }
    //imprimir valores
    System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) á(%d) é(%d) í­(%d) ó(%d) ú(%d) à(%d) è(%d) ì(%d) ò(%d) ù(%d) ã(%d) õ(%d) â(%d) ê(%d) î(%d) ô(%d) û(%d) consoante(%d) <br>(%d) <table>(%d) ", x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21,x22, x23, x24, x25);
    System.out.println(NomeDaPagina);
    }

    public static boolean isfim(String b) {
        if(b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3) 
        return false;
        return true;
        
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

        for (int i = 0; i < y; i += 2) {
         verifica(getHtml(str[i + 1]), str[i]);
            }

    } 
}