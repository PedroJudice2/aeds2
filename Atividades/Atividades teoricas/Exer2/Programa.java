class Programa {
    public static void main(String[] args) {

        Arvore arvore = new Arvore();
        arvore.inserir("Mario");
        arvore.inserir("Joao");
        arvore.inserir("Gregoria");
        arvore.inserir("Pedro");
        arvore.inserir("Felipe");
        arvore.inserir("Leticia");
        arvore.inserir("Richard");
        arvore.inserir("Diana");
        arvore.inserir("Beatriz");
        arvore.inserir("Julio");
        arvore.inserir("Vitor");
        arvore.inserir("Luh");
        arvore.inserir("Maria Jumentonia");
        arvore.inserir("Gregoria");

        if (arvore.pesquisar(args[0])) {
            System.out.println("Achou");
        } else {
            System.out.println("Não achou");
        }
        arvore.mostar();
    }
}