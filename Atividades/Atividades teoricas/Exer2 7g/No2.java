public class No2 {
    // segunda arvore normal
    private String nome;
    No2 dir;
    No2 esq;

    No2(String nome) {
        this.nome = nome;
        dir = null;
        esq = null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
