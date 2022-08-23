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
     int 23 = 0; //consoante
     int 24 = 0; //<br>
     int 25 = 0; //<table>

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

        //verificar ocorrencias com assento
        else if()
     }
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

        for (int i = 0; i < y; i++) {
            System.out.println(getHtml(str[i]));
            }
    } 
 }