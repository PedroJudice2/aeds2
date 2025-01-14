
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
    // criar lista global
    public static HashIndiretoLista hashDeJogos = new HashIndiretoLista();

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
                        hashDeJogos.inserirInicio(jogo);
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

        // linear search
        do {
            linhaEntrada = sc.nextLine();
            if (isFim(linhaEntrada) == false) {
                System.out.println("=> " + linhaEntrada);
                int pos = hashDeJogos.pesquisar(linhaEntrada);
                if (pos == -1) {
                    System.out.println("NAO");
                } else {
                    System.out.println("Posicao: " + pos);
                }
            }
        } while (isFim(linhaEntrada) == false);

        sc.close();
    }

}

class HashIndiretoLista {
    Lista tabela[];
    int tamanho;

    public HashIndiretoLista() {
        this(21);
    }

    public HashIndiretoLista(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new Lista();
        }
    }

    public int h(int elemento) {
        return elemento % tamanho;
    }

    int pesquisar(String elemento) {
        int pos = h(elemento.chars().sum());
        if (tabela[pos].pesquisar(elemento)) {
            return pos;
        } else {
            return -1;
        }
    }

    public void inserirInicio(Game elemento) {
        int pos = h(elemento.getName().chars().sum());
        tabela[pos].inserirInicio(elemento);
    }

}

class Celula {
    public Game elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.

    /**
     * Construtor da classe.
     * 
     * @param elemento Elemento inserido na celula.
     */
    Celula(Game elemento) {
        this.elemento = elemento;
        this.prox = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Elemento inserido na celula.
     * @param prox     Aponta a celula prox.
     */
    Celula(Game elemento, Celula prox) {
        this.elemento = elemento;
        this.prox = prox;
    }
}

/**
 * Lista dinamica simplesmente encadeada
 * 
 * @author Joao Paulo Domingos Silva
 * @version 1.1 02/2012
 */
class Lista {
    private Celula primeiro; // Primeira celula: SEM elemento valido.
    private Celula ultimo; // Ultima celula: COM elemento valido.

    /**
     * Construtor da classe: Instancia uma celula (primeira e ultima).
     */
    public Lista() {
        primeiro = new Celula(null);
        ultimo = primeiro;
    }

    /**
     * Mostra os elementos separados por espacos.
     */
    public void mostrar() {
        System.out.print("[ "); // Comeca a mostrar.
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] "); // Termina de mostrar.
    }

    /**
     * Procura um elemento e retorna se ele existe.
     * 
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String x) {
        boolean retorno = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getName().equals(x)) {
                retorno = true;
                i = ultimo;
            }
        }
        return retorno;
    }

    /**
     * Insere um elemento na primeira posicao da sequencia.
     * 
     * @param elemento Elemento a inserir.
     */
    public void inserirInicio(Game elemento) {
        Celula tmp = new Celula(elemento);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da sequencia.
     * 
     * @param elemento Elemento a inserir.
     */
    public void inserirFim(Game elemento) {
        Celula tmp = new Celula(elemento);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
        tmp = null;
    }

    /**
     * Insere elemento em um indice especifico.
     * Considera que primeiro elemento esta no indice 0.
     * 
     * @param x       Elemento a inserir.
     * @param posicao Meio da insercao.
     * @throws Exception Se <code>posicao</code> for incorreta.
     */
    public void inserirMeio(Game x, int posicao) throws Exception {
        Celula i;
        int cont;

        // Caminhar ate chegar na posicao anterior a insercao
        for (i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++)
            ;

        // Se indice for incorreto:
        if (posicao < 0 || posicao > cont + 1) {
            throw new Exception("Erro ao inserir (posicao " + posicao + "(cont = " + cont + ") invalida)!");

        } else if (posicao == cont + 1) {
            inserirFim(x);
        } else {
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    /**
     * Remove um elemento da primeira posicao da sequencia.
     * 
     * @return Elemento removido.
     * @throws Exception Se a sequencia nao contiver elementos.
     */
    public Game removerInicio() throws Exception {
        Game resp = null;

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        } else {
            primeiro = primeiro.prox;
            resp = primeiro.elemento;
        }

        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da sequencia.
     * 
     * @return Elemento removido.
     * @throws Exception Se a sequencia nao contiver elementos.
     */
    public Game removerFim() throws Exception {
        Game resp = null;
        Celula i = null;

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        } else {

            resp = ultimo.elemento;

            // Caminhar ate a penultima celula:
            for (i = primeiro; i.prox != ultimo; i = i.prox)
                ;

            ultimo = i;
            i = ultimo.prox = null;
        }

        return resp;
    }

    /**
     * Remove elemento de um indice especifico.
     * Considera que primeiro elemento esta no indice 0.
     * 
     * @param posicao Meio da remocao.
     * @return Elemento removido.
     * @throws Exception Se <code>posicao</code> for incorreta.
     */
    public Game removerMeio(int posicao) throws Exception {
        Celula i;
        Game resp = null;
        int cont;

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        } else {

            // Caminhar ate chegar na posicao anterior a insercao
            for (i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++)
                ;

            // Se indice for incorreto:
            if (posicao < 0 || posicao > cont + 1) {
                throw new Exception("Erro ao remover (posicao " + posicao + " invalida)!");

            } else if (posicao == cont + 1) {
                resp = removerFim();
            } else {
                Celula tmp = i.prox;
                resp = tmp.elemento;
                i.prox = tmp.prox;
                tmp.prox = null;
                i = tmp = null;
            }
        }

        return resp;
    }
}