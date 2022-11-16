
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Game {
    // date
    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    // Inicializar os atributos
    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPlaytime(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPlaytime() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {
        Game cloned = new Game();
        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        return cloned;
    }

    public void ler(String line) {
        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //
        // Find "AppID"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.app_id = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Name"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.name = line.substring(atr_index, index);
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find release date
        if (line.charAt(atr_index) != ',') {
            SimpleDateFormat df;
            if (line.charAt(atr_index) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                atr_index++;
                c_search = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                c_search = ',';
            }
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find "Owners"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.owners = line.substring(atr_index, index);
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Age"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Price"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "DLCs"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Languages"
        while (true) {
            index++;
            if (line.charAt(index) == ']') {
                index++;
                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;
                atr_index = index;
                break;
            } else if (line.charAt(index) == '\'') {
                int wordStart = index + 1;
                while (true) {
                    index++;
                    if (line.charAt(index) == '\'') {
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        // Find "Website"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.website = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Windows"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Upvotes"
        int positives, negatives;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                positives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                negatives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

        // ---------------------------------- //
        // Find "AVG Playtime"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Developers"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.developers = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;
        // ---------------------------------- //

        // Find "Genres"
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                while (true) {
                    index++;
                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(atr_index, index));
                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }
    }

    public void imprimir() {
        String avg_pt = null;
        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {
            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format("%.2f", this.price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
}

public class Programa {

    public static int swap(int a, int b) {
        return a;
    }

    // criar lista global
    public static CListaDup listaDeJogos = new CListaDup();

    public static boolean isFim(String line) {
        return (line.length() == 3 && line.charAt(0) == 'F' && line.charAt(1) == 'I' && line.charAt(2) == 'M');
    }

    public static void carregar(String linhaEntrada) throws FileNotFoundException {
        int flag = 0;
        FileInputStream path = new FileInputStream("/tmp/games.csv");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(path));
            String linhaCSV;
            do { // passar pelo CSV
                linhaCSV = br.readLine();
                if (linhaCSV != null) { // quando acabar o CSV
                    String[] nome = linhaCSV.split(",");
                    if (linhaEntrada.equals(nome[0])) {
                        Game jogo = new Game();
                        jogo.ler(linhaCSV);
                        listaDeJogos.insereFim(jogo);
                        flag++;
                    }
                }
            } while (linhaCSV != null && flag == 0); // quando acabar o CSV
            flag = 0;
            path.getChannel().position(0);
            br = new BufferedReader(new InputStreamReader(path));
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        Date pivo = ((Game) listaDeJogos.retornaIndice((dir + esq) / 2)).getReleaseDate();
        while (i <= j) {
            while (((Game) listaDeJogos.retornaIndice(i)).getReleaseDate().compareTo(pivo) < 0)
                i++;
            while (((Game) listaDeJogos.retornaIndice(j)).getReleaseDate().compareTo(pivo) > 0)
                j--;
            if (i <= j) {
                listaDeJogos.swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(esq, j);
        if (i < dir)
            quicksort(i, dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linhaEntrada;
        // carregar app id
        do {
            linhaEntrada = sc.nextLine();
            if (isFim(linhaEntrada) == false) {
                try {
                    carregar(linhaEntrada);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } while (isFim(linhaEntrada) == false);

        // sortear valores
        quicksort(1, (listaDeJogos.quantidade()));

        // imprimir valores

        listaDeJogos.impimirGame();

        sc.close();
    }

}

class CCelulaDup {

    public Object item; // O Item armazendo pela clula
    public CCelulaDup ant; // Referencia a celula anterior
    public CCelulaDup prox; // Referencia a proxima celula

    // Inicializa uma nova instancia da classe CCelulaDup atribuindo null aos
    // atributos Item, Ant e Prox.
    public CCelulaDup() {
        item = null;
        ant = null;
        prox = null;
    }

    // Inicializa uma nova instancia da classe CCelula atribuindo o valor passado
    // por parametro ao atributo Item e null aos atributos Ant e Prox.
    // O parametro "valorItem" recebe o valor a ser armazenado pela celula.
    public CCelulaDup(Object valorItem) {
        item = valorItem;
        ant = null;
        prox = null;
    }

    // Inicializa uma nova instancia da classe CCelula atribuindo ValorItem ao
    // atributo Item e ProxCelula ao atributo Prox.
    // O parametro "valorItem" recebe o valor a ser armazenado pela celula.
    // Os parametros "celulaAnt" e "proxCelula" recebem as referencias para a celula
    // anterior e para a proxima celula.
    public CCelulaDup(Object valorItem, CCelulaDup celulaAnt, CCelulaDup proxCelula) {
        item = valorItem;
        ant = celulaAnt;
        prox = proxCelula;
    }
}

class CListaDup {
    private CCelulaDup primeira; // Referencia a primeira celula da lista (celula cabeca)
    private CCelulaDup ultima; // Referencia a ultima celula da lista
    private int qtde;

    // Aloca a celula cabeca e faz todas as referencias
    // apontarem para ela.
    public CListaDup() {
        primeira = new CCelulaDup();
        ultima = primeira;
    }

    // Verifica se a lista esta vazia.
    public boolean vazia() {
        return primeira == ultima;
    }

    // Insere um novo elemento no fim da lista.
    public void insereFim(Object valorItem) {
        ultima.prox = new CCelulaDup(valorItem, ultima, null);
        ultima = ultima.prox;
        qtde++;
    }

    // Insere um novo elemento no comeco da lista.
    public void insereComeco(Object valorItem) {
        if (primeira == ultima) { // Se a lista estiver vazia insere no fim
            ultima.prox = new CCelulaDup(valorItem, ultima, null);
            ultima = ultima.prox;
        } else { // senao insere no comeco
            primeira.prox = new CCelulaDup(valorItem, primeira, primeira.prox);
            primeira.prox.prox.ant = primeira.prox;
        }
        qtde++;
    }

    // Remove o primeiro elemento da lista. Na verdade, remove a referencia para a
    // celula cabeca, e torna a primeira celula na nova celula cabeca
    public void removeComecoSemRetorno() {
        if (primeira != ultima) {
            primeira = primeira.prox;
            primeira.ant = null;
            qtde--;
        }
    }

    // Imprime todos os elementos da lista duplamente encadeada usando o comando
    // while.
    public void imprime() {
        CCelulaDup aux = primeira.prox;
        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.prox;
        }
    }

    // Imprime todos os elementos da lista duplamente encadeada usando o comando
    // for.
    public void imprimeFor() {
        for (CCelulaDup aux = primeira.prox; aux != null; aux = aux.prox)
            System.out.println(aux.item);
    }

    // Imprime todos os elementos da lista duplamente encadeada em sentido inverso
    // usando o comando while.
    public void imprimeInv() {
        CCelulaDup aux = ultima;
        while (aux.ant != null) {
            System.out.println(aux.item);
            aux = aux.ant;
        }
    }

    // Imprime todos os elementos da lista duplamente encadeada em sentido inverso
    // usando o comando for.
    public void imprimeInvFor() {
        for (CCelulaDup aux = ultima; aux.ant != null; aux = aux.ant)
            System.out.println(aux.item);
    }

    // Verifica se o Item passado como parametro esta contido na lista.
    public boolean contem(Object elemento) {
        boolean achou = false;
        CCelulaDup aux = primeira.prox;
        while (aux != null && !achou) {
            achou = aux.item.equals(elemento);
            aux = aux.prox;
        }
        return achou;
    }

    // Verifica se o Item passado como parametro esta contido na lista. (Obs: usa o
    // comando FOR)
    public boolean contemFor(Object elemento) {
        boolean achou = false;
        for (CCelulaDup aux = primeira.prox; aux != null && !achou; aux = aux.prox)
            achou = aux.item.equals(elemento);
        return achou;
    }

    // Retorna o primeiro elemento da lista.
    public Object retornaPrimeiro() {
        if (primeira != ultima)
            return primeira.prox.item;
        return null;
    }

    // Retorna o Item contido na posicao p da lista.
    public Object retornaIndice(int posicao) {
        // deve retornar o elemento da posicao p passada por parametro
        // [cabeca]->[7]->[21]->[13]->null
        // retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posicao
        // inexistente deve retornar null.
        // Se e uma posicao valida e a lista possui elementos
        if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
            CCelulaDup aux = primeira.prox;
            // Procura a posicao a ser inserido
            for (int i = 1; i < posicao; i++, aux = aux.prox)
                ;
            if (aux != null)
                return aux.item;
        }
        return null;
    }

    // retornar celula na posição desejada
    private CCelulaDup retornaCelulaIndice(int posicao) {
        if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
            CCelulaDup aux = primeira.prox;
            // Procura a posicao a ser inserido
            for (int i = 1; i < posicao; i++, aux = aux.prox)
                ;
            if (aux != null)
                return aux;
        }
        return null;
    }

    // Retorna o elemento da ultima posicao.
    public Object retornaUltimo() {
        if (primeira != ultima)
            return ultima.item;
        return null;
    }

    // Remove o ultimo elemento da lista. Na verdade, remove as referencias para a
    // ultima celula, forcando que o Garbage Collector desaloque a ultima celula
    public void removeFimSemRetorno() {
        if (primeira != ultima) {
            ultima = ultima.ant;
            ultima.prox = null;
            qtde--;
        }
    }

    // Localiza o Item passado por parametro e o remove da Lista
    public void remove(Object valorItem) {
        if (primeira != ultima) {
            CCelulaDup aux = primeira.prox;
            boolean achou = false;
            while (aux != null && !achou) {
                achou = aux.item.equals(valorItem);
                if (!achou)
                    aux = aux.prox;
            }
            if (achou) { // achou o elemento
                CCelulaDup anterior = aux.ant;
                CCelulaDup proximo = aux.prox;
                anterior.prox = proximo;
                if (proximo != null)
                    proximo.ant = anterior;
                else
                    ultima = anterior;
                qtde--;
            }
        }
    }

    // Remove e retorna o primeiro elemento da lista.
    public Object removeRetornaComeco() {
        if (primeira != ultima) {
            CCelulaDup aux = primeira.prox;
            primeira = primeira.prox;
            primeira.ant = null;
            qtde--;
            return aux.item;
        }
        return null;
    }

    // Remove e retorna o ultimo elemento da lista.
    public Object removeRetornaFim() {
        if (primeira != ultima) {
            CCelulaDup aux = ultima;
            ultima = ultima.ant;
            ultima.prox = null;
            qtde--;
            return aux.item;
        }
        return null;
    }

    // Metodo que retorna a quantidade de elementos da lista.
    public int quantidade() {
        return qtde;
    }

    public void teste() {
        CCelulaDup i = primeira.prox;
        CCelulaDup j = ultima;
        CCelulaDup k;
        while (j.prox != i) {
            Object tmp = i.item;
            i.item = j.item;
            j.item = tmp;
            i = i.prox;
            for (k = primeira; k.prox != j; k = k.prox)
                ;
            j = k;
        }
    }

    public void teste2() {
        CCelulaDup i = primeira.prox;
        CCelulaDup j = ultima;
        CCelulaDup k;
        while (i != j && j.prox != i) {
            Object tmp = i.item;
            i.item = j.item;
            j.item = tmp;
            i = i.prox;
            for (k = primeira; k.prox != j; k = k.prox)
                ;
            j = k;
        }
    }

    // trocar elementos
    public void swap(int pos1, int pos2) {
        if ((pos1 >= 1 && pos2 >= 1 && pos1 != pos2) && (pos1 <= qtde && pos2 <= qtde) && (primeira != ultima)) {
            Object temp = retornaIndice(pos1);
            retornaCelulaIndice(pos1).item = retornaCelulaIndice(pos2).item;
            retornaCelulaIndice(pos2).item = temp;
        }
    }

    // imprimir game
    public void impimirGame() {
        if (primeira != ultima) {
            CCelulaDup aux = primeira.prox;
            while (aux.prox != null) {
                ((Game) aux.item).imprimir();
                aux = aux.prox;
            }
        }
    }

}