public class Arvore {

    private No raiz;
    // vetor com letras do alfabeto em ordem para deixar arvore balanciada
    char alfabeto[] = { 'M', 'F', 'T', 'I', 'C', 'P', 'W', 'K', 'G', 'D', 'A', 'R', 'Y', 'N', 'U', 'B', 'E', 'H',
            'J', 'L', 'O', 'Q', 'S', 'V', 'X', 'Z' };

    Arvore() {
        // inserir letras do alfabeto na arvore
        for (int i = 0; i < alfabeto.length; i++) {
            inicializar(alfabeto[i]);
        }
    }

    private void inicializar(char letra) {
        try {
            raiz = inicializar(letra, raiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private No inicializar(char letra, No i) throws Exception {
        if (i == null) {
            i = new No(letra);
        } else if (Character.compare(letra, i.getLetra()) == 0) {
            throw new Exception("letra ja inserida");
        } else if (Character.compare(letra, i.getLetra()) > 0) {
            i.dir = inicializar(letra, i.dir);
        } else {
            i.esq = inicializar(letra, i.esq);
        }
        return i;
    }

    public void inserir(String str) {
        try {
            inserir(str, raiz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void inserir(String str, No i) throws Exception {
        if (i == null) {
            throw new Exception("caractere invalido");
        } else if (Character.compare(Character.toUpperCase(str.charAt(0)), i.getLetra()) == 0) {
            i.outro = inserir(str, i.outro);
        } else if (Character.compare(Character.toUpperCase(str.charAt(0)), i.getLetra()) > 0) {
            inserir(str, i.dir);
        } else {
            inserir(str, i.esq);
        }
    }

    No2 inserir(String str, No2 i) throws Exception {
        if (i == null) {
            i = new No2(str);
        } else if (str.compareTo(i.getNome()) == 0) {
            throw new Exception("nome ja inserido");
        } else if (str.compareTo(i.getNome()) > 0) {
            i.dir = inserir(str, i.dir);
        } else {
            i.esq = inserir(str, i.esq);
        }
        return i;
    }

    public boolean pesquisar(String str) {
        try {
            return pesquisar(str, raiz);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    boolean pesquisar(String str, No i) throws Exception {
        boolean resp;
        if (i == null) {
            throw new Exception("caractere invalido");
        } else if (Character.compare(Character.toUpperCase(str.charAt(0)), i.getLetra()) == 0) {
            resp = pesquisar(str, i.outro);
        } else if (Character.compare(Character.toUpperCase(str.charAt(0)), i.getLetra()) > 0) {
            resp = pesquisar(str, i.dir);
        } else {
            resp = pesquisar(str, i.esq);
        }
        return resp;
    }

    boolean pesquisar(String str, No2 i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (str.compareTo(i.getNome()) == 0) {
            resp = true;
        } else if (str.compareTo(i.getNome()) > 0) {
            resp = pesquisar(str, i.dir);
        } else {
            resp = pesquisar(str, i.esq);
        }
        return resp;
    }

    public void mostar() {
        caminharEmOrdem(raiz);
    }

    void caminharEmOrdem(No i) {
        if (i != null) {
            caminharEmOrdem(i.esq);
            caminharEmOrdem2(i.outro);
            // System.out.println(i.getLetra());
            caminharEmOrdem(i.dir);
        }
    }

    void caminharEmOrdem2(No2 i) {
        if (i != null) {
            caminharEmOrdem2(i.esq);
            System.out.println(i.getNome());
            caminharEmOrdem2(i.dir);
        }
    }

}
