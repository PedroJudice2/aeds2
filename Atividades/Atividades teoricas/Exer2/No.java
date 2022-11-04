public class No {
    // arvore modificada para ter ponteiro para nova arvore
    private char letra;
    No dir;
    No esq;
    No2 outro;

    No(char letra) {
        this.letra = letra;
        dir = null;
        esq = null;
        outro = null;
    }

    public char getLetra() {
        return this.letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

}
