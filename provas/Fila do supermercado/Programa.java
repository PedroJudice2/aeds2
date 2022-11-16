import java.util.Scanner;

class Programa {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int nFuncionarios = sc.nextInt();
        int[] tempoFuncionarios = new int[nFuncionarios];
        int nClientes = sc.nextInt();
        int[] clientes = new int[nClientes];
        int somaTempo = 0;
        sc.nextLine();
        for (int i = 0; i < nFuncionarios; i++) {
            tempoFuncionarios[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < nClientes; i++) {
            clientes[i] = sc.nextInt();
        }
        
         for (int i = 0, j = 0; i < nClientes; i++) {
            if (nFuncionarios < 2) {
                somaTempo += tempoFuncionarios[0] * clientes[i];
            }
            else {
                    somaTempo += tempoFuncionarios[j] * clientes[i];
            }
            
        }

        System.out.println(somaTempo);
    }
}
