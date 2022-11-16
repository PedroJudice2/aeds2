import java.util.Scanner;

class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada;
        while (sc.hasNext()) {
            entrada = sc.nextInt();
            sc.nextLine();
            String linha;
            String[] atr = new String[2];
            Carne[] carne = new Carne[entrada];
            for (int i = 0; i < entrada; i++) {
                linha = sc.nextLine();
                atr = linha.split(" ");
                carne[i] = new Carne(atr[0], Integer.parseInt(atr[1]));
            }
            bubbleSort(carne, carne.length);
            for (int i = 0; i < carne.length; i++) {
                System.out.print(carne[i].nome + " ");
            }
            System.out.println();

        }

    }

    public static void bubbleSort(Carne[] carne, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (carne[j].val > carne[j + 1].val) {
                    Carne tmp;
                    tmp = carne[j + 1];
                    carne[j + 1] = carne[j];
                    carne[j] = tmp;
                }
            }
        }
    }

}

class Carne {
    public String nome;
    public int val;

    Carne(String nome, int val) {
        this.nome = nome;
        this.val = val;
    }
}