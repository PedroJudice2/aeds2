import java.util.Scanner;

class Programa {
    public static String[] bubblesort(String[] array, int count) {
        String temp;
        int swap = 0;
        for (int i = 0; i < count; i++) {
            swap = 0;
            for (int j = 0; j < count - i - 1; j++) {
                if (Integer.valueOf(array[j]) > Integer.valueOf(array[j + 1])) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                i = 1000000;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n;
        String[] array = new String[20];
        int count = 0;
        String[] sorted = new String[20];

        while (sc.hasNext()) {
            n = sc.nextLine();
            count = 0;
            for (int i = 0; i < Integer.valueOf(n); i++) {
                array[i] = sc.nextLine();
                count++;
            }
            sorted = bubblesort(array, count);
            for (int i = 0; i < count; i++) {
                System.out.println(sorted[i]);
            }

        }
        sc.close();
    }
}