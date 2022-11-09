import java.util.Scanner;

class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        int nFileira;
        int difAltura;
        sc.nextLine();
        for (int i = 0; i < entrada; i++) {
            nFileira = sc.nextInt();
            difAltura = sc.nextInt();
            sc.nextLine();
            int[] altura = new int[nFileira * 2];
            for (int j = 0; j < nFileira * 2; j++) {
                altura[j] = sc.nextInt();
            }
            bubbleSort(altura, nFileira * 2);
            if (comparar(altura, nFileira, difAltura)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }

    }

    public static void bubbleSort(int[] array, int count) {
        int swap;
        for (int i = 0; i < count; i++) {
            swap = 0;
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                i = 100000000;
            }
        }
    }

    public static boolean comparar(int[] array, int count, int key) {
        for (int i = 0; i < count; i++) {
            if (array[i + count] - array[i] < key) {
                return false;
            }
        }
        return true;
    }
}