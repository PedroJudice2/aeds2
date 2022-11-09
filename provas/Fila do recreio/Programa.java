import java.util.Scanner;

class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        int count = 0;
        String temporaria;
        for (int i = 0; i < entrada; i++) {
            int numeroAlunos = sc.nextInt();
            sc.nextLine();
            int[] filaAlunos = new int[numeroAlunos];
            String[] tmp = new String[numeroAlunos];
            temporaria = sc.nextLine();
            tmp = temporaria.split(" ");
            for (int j = 0; j < numeroAlunos; j++) {
                filaAlunos[j] = Integer.parseInt(tmp[j]);
            }

            int[] sorted = new int[numeroAlunos];
            for (int x = 0; x < numeroAlunos; x++) {
                sorted[x] = filaAlunos[x];
            }
            bubbleSort(sorted, numeroAlunos);
            for (int z = 0; z < numeroAlunos; z++) {

                if (sorted[z] == filaAlunos[z]) {
                    count++;
                }
            }
            System.out.println(count);
            count = 0;

        }
    }

    public static void bubbleSort(int[] array, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
}