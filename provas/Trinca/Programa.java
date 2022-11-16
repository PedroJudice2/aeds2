import java.util.Scanner;

class Programa {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        for (int i = 0; i < entrada; i++) {
            int arraySize = sc.nextInt();
            int[] array = new int[arraySize];
            if (arraySize > 2) {
                for (int j = 0; j < arraySize; j++) {
                    array[j] = sc.nextInt();
                    }
                    bubbleSort(array, arraySize);
                    if(!(possui(array, arraySize))) {
                        System.out.println(-1);
                    }
                }
                else {
                    System.out.println(-1);
                    sc.nextInt();
                }
            }
        }

        public static void bubbleSort(int[] array, int count) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    

        public static boolean possui (int[] array, int count) {
            int contar = 0;
            for (int i = 0; i< count; i++) {
                for (int j = 0; j < count; j++) {
                    if (array[i] == array[j]) {
                        contar++;
                    }
                }
                if (contar >= 3) {
                    System.out.println(array[i]);
                    return true;
                }
                else {
                    contar = 0;
                }
            }
            return false;
        }
        
}