import java.util.*; 

class Programa {


    public static void main (String[] args) {
    // criar scanner
    Scanner sc= new Scanner(System.in);
    String str;

    // checar fim do arquivo
    do {
        boolean pal = true;
        str = sc.nextLine();
        if (!(str.equals("FIM"))) {
          for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                pal = false;
                i = 10000;
            }
        } 

        if (pal == true) {
            System.out.println("SIM");
        }
        else {
            System.out.println("NAO");
        }
    }
    } while (!(str.equals("FIM")));
    } 
}