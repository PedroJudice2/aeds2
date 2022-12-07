import java.util.Scanner;

class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTestes = sc.nextInt();
        for (int i = 0; i < nTestes; i++) {
            // duas matrizes por caso teste
            for (int y = 0; y < 2; y++) {
                int linha = sc.nextInt();
                int coluna = sc.nextInt();

            }
        }
    }
}

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

}