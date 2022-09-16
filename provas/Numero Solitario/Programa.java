import java.util.Scanner;

class Programa {

    public static int[] bubblesort(int[] array, int count) {
        int temp;
        int swap;
        for (int i = 0; i < count; i++) {
            swap = 0;
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                i = 10000;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] grupo = new int[20];
        int count = 0;
        int dupla = 0;
        int[] sorted = new int[20];

        int x = 0;
        int flag;
        do {
            n = sc.nextInt();
            if (n != 0) {
                count = 0;
                for (int i = 0; i < n; i++) {
                    grupo[i] = sc.nextInt();
                    count++;
                }
                sorted = bubblesort(grupo, count);
                int[] ja = new int[20];
                for (int i = 0; i < n; i++) {
                    dupla = 0;
                    flag = 0;
                    for (int y = 0; y < x; y++) {
                        if (sorted[i] == ja[y]) {
                            flag++;
                            y = 10000000;
                        }
                    }
                    ja[x++] = sorted[i];
                    if (flag == 0) {
                        for (int j = i + 1; j < n; j++) {
                            if (sorted[i] == sorted[j]) {
                                dupla++;
                            }
                        }
                        if (dupla % 2 == 0) {
                            System.out.println(sorted[i]);
                        }
                    }
                }

            }
        } while (n != 0);
        sc.close();
    }
}