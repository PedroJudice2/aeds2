import java.util.Scanner;

class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nEntrada = sc.nextInt();
        for (int i = 0; i < nEntrada; i++) {
            HashTable hashTable = new HashTable(sc.nextInt());
            int qtdNumero = sc.nextInt();
            for (int j = 0; j < qtdNumero; j++) {
                hashTable.insert(sc.nextInt());
            }
            hashTable.mostrar();
            if (i != nEntrada - 1)
                System.out.println();
        }

        sc.close();
    }
}

class HashTable {

    int tamanho;
    No[] array;

    HashTable(int tamanho) {
        this.tamanho = tamanho;
        array = new No[tamanho];

    }

    public int Hash(int x) {
        return x % tamanho;
    }

    public void insert(int x) {
        if (array[Hash(x)] == null) {
            array[Hash(x)] = new No(x);
        } else {
            No curr = array[Hash(x)];
            while (curr.prox != null) {
                curr = curr.prox;
            }
            curr.prox = new No(x);
        }
    }

    public void mostrar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ->");
            if (array[i] != null) {
                No curr = array[i];
                System.out.print(" " + curr.elemento + " ->");
                while (curr.prox != null) {
                    System.out.print(" " + curr.prox.elemento + " ->");
                    curr = curr.prox;
                }
                System.out.println(" \\");
            } else {
                System.out.println(" \\");
            }
        }
    }
}

class No {
    int elemento;
    No prox;

    No(int elemento) {
        this.elemento = elemento;
        prox = null;
    }
}