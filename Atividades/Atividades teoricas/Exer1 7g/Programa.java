class Contato {
    private String nome;
    private String telefone;
    private String email;
    private int CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCPF() {
        return this.CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

}

class Celula {
    Contato contato;
    Celula prox;

    Celula() {
        this.contato = null;
        this.prox = null;
    }

    Celula(Contato valorItem) {
        this.contato = valorItem;
        this.prox = null;
    }

}

class No {
    No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }

    public void insereFim(Contato valorItem) {
        ultimo.prox = new Celula(valorItem);
        ultimo = ultimo.prox;
    }

    public void remove(String valorItem) {
        if (primeiro != ultimo) {
            Celula aux = primeiro;
            boolean achou = false;
            while (aux.prox != null && !achou) {
                achou = aux.prox.contato.getNome().equals(valorItem);
                if (!achou)
                    aux = aux.prox;
            }
            if (achou) {
                // achou o elemento
                aux.prox = aux.prox.prox;
                if (aux.prox == null)
                    ultimo = aux;
            }
        }
    }

    public boolean contem(String elemento) {
        boolean achou = false;
        Celula aux = primeiro.prox;
        while (aux != null && !achou) {
            achou = aux.contato.getNome().equals(elemento);
            aux = aux.prox;
        }
        return achou;
    }

    public boolean contem(int elemento) {
        boolean achou = false;
        Celula aux = primeiro.prox;
        while (aux != null && !achou) {
            achou = aux.contato.getCPF() == elemento;
            aux = aux.prox;
        }
        return achou;
    }

    char letra;
    No esq;
    No dir;
    Celula primeiro;
    Celula ultimo;
}

class Agenda {
    No raiz;

    Agenda() {
        char alfabeto[] = { 'M', 'F', 'T', 'I', 'C', 'P', 'W', 'K', 'G', 'D', 'A', 'R', 'Y', 'N', 'U', 'B', 'E', 'H',
                'J', 'L', 'O', 'Q', 'S', 'V', 'X', 'Z' };
        for (int i = 0; i < 26; i++) {
            try {
                inicializar(alfabeto[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inicializar(char letra) throws Exception {
        raiz = inicializar(letra, raiz);
    }

    No inicializar(char letra, No i) throws Exception {
        if (i == null) {
            i = new No(letra);
        } else if (Character.compare(letra, i.letra) > 0) {
            i.dir = inicializar(letra, i.dir);
        } else if (Character.compare(letra, i.letra) < 0) {
            i.esq = inicializar(letra, i.esq);
        } else {
            throw new Exception("Erro");
        }
        return i;
    }

    public void inserir(Contato contato) throws Exception {
        inserir(contato, raiz);
    }

    public void inserir(Contato contato, No i) throws Exception {
        char letra = contato.getNome().charAt(0);
        letra = Character.toUpperCase(letra);
        if (i == null) {
            throw new Exception("Erro");
        } else if (Character.compare(letra, i.letra) == 0) {
            i.insereFim(contato);
        } else if (Character.compare(letra, i.letra) > 0) {
            inserir(contato, i.dir);
        } else {
            inserir(contato, i.esq);
        }
    }

    public void remover(String nome) throws Exception {
        remover(nome, raiz);
    }

    public void remover(String nome, No i) throws Exception {
        char letra = nome.charAt(0);
        letra = Character.toUpperCase(letra);
        if (i == null) {
            throw new Exception("Erro");
        } else if (Character.compare(letra, i.letra) == 0) {
            i.remove(nome);
        } else if (Character.compare(letra, i.letra) > 0) {
            remover(nome, i.dir);
        } else {
            remover(nome, i.esq);
        }
    }

    public boolean pesquisar(String nome) throws Exception {
        return pesquisar(nome, raiz);
    }

    public boolean pesquisar(String nome, No i) throws Exception {
        boolean resp;
        char letra = nome.charAt(0);
        letra = Character.toUpperCase(letra);
        if (i == null) {
            throw new Exception("Erro");
        } else if (Character.compare(letra, i.letra) == 0) {
            resp = i.contem(nome);
        } else if (Character.compare(letra, i.letra) > 0) {
            resp = pesquisar(nome, i.dir);
        } else {
            resp = pesquisar(nome, i.esq);
        }
        return resp;
    }

    public boolean pesquisar(int cpf) throws Exception {
        return pesquisar(cpf, raiz);
    }

    public boolean pesquisar(int cpf, No i) throws Exception {
        boolean resp = false;
        if (i != null) {
            if (i.contem(cpf)) {
                resp = true;
            } else if (pesquisar(cpf, i.esq) || pesquisar(cpf, i.dir)) {
                resp = true;
            }
        }
        return resp;
    }

}

class Programa {
    public static void main(String[] args) throws Exception {
        Contato teste = new Contato();
        teste.setNome("Zambia");
        teste.setCPF(123);

        Agenda arvore = new Agenda();
        arvore.inserir(teste);
        if (Integer.parseInt(args[0]) == 1) {
            if (arvore.pesquisar(args[1])) {
                System.out.println("Achou");
            } else {
                System.out.println("Não achou");
            }
        } else {
            if (arvore.pesquisar(Integer.parseInt(args[1]))) {
                System.out.println("Achou");
            } else {
                System.out.println("Não achou");
            }
        }

    }
}