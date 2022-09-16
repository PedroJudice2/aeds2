import java.util.*;
import java.util.Scanner;

class Principal {

    public static String[] ordenar(String[] a, int count) {
        int menor = 0;
        for (int i = 0; i < (count - 1); i++) {
            menor = i;
            for (int j = (i + 1); j < count; j++) {
                if (Integer.valueOf(a[menor]) > Integer.valueOf(a[j])) {
                    menor = j;
                }
            }
            String temp = a[menor];
            a[menor] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] array = new String[1000];
        int n;
        int count = 0;
        String[] vetor = new String[1000];

        while (entrada.hasNext()) {
            count = 0;
            n = entrada.nextInt();
            for (int i = 0; i < n; i++) {
                array[i] = entrada.nextLine();
                count++;
            }
            vetor = ordenar(array, count);
        }
        for (int i = 0; i < count; i++) {
            System.out.print(vetor[i]);
        }
    }

}