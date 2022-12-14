import java.util.Scanner;

class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nNumeros = sc.nextInt();
            sc.nextLine();
            int count = 0;
            String[] entradas = new String[nNumeros];
            for (int i = 0; i < nNumeros; i++) {
                entradas[i] = sc.nextLine();
            }
            for (int i = nNumeros - 1; i > 0; i--) {
                for (int j = 0; j < entradas[i].length(); j++) {
                    if (entradas[i].charAt(j) == entradas[i - 1].charAt(j)) {
                        count++;
                    } else {
                        j = entradas[i].length(); // break
                    }
                }
            }
            System.out.println(count);
        }
    }
}