
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
                + this.owners + " " + this.age + " " + String.format(Locale.US, "%.2f", price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
}

public class Programa {
    // criar lista global
    public static Arvore arvoreDeJogos = new Arvore();

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
                        try {
                            arvoreDeJogos.inserir(jogo.getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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

        // opercaçoes da arvore
        int operacoes = sc.nextInt();
        sc.nextLine();
        String options;

        for (int i = 0; i < operacoes; i++) {
            options = sc.nextLine();
            String[] items = options.split(" ");
            if (items[0].equals("I")) {
                try {
                    carregar(items[1]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        // pesquisar arvore
        /*
         * do {
         * options = sc.nextLine();
         * if (isFim(options) == false) {
         * System.out.println(options);
         * System.out.print("raiz ");
         * if (arvoreDeJogos.pesquisarTp(options)) {
         * System.out.println("SIM");
         * } else {
         * System.out.println("NAO");
         * }
         * 
         * }
         * } while (isFim(options) == false);
         */
        arvoreDeJogos.mostar();
        sc.close();
    }

}

// ------------------ classes da Arvore -------------------------
class No {
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

class No2 {
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

class Arvore {

    private No raiz;
    // vetor com letras do alfabeto em ordem para deixar arvore balanciada
    char alfabeto[] = { 'D', 'R', 'Z', 'X', 'V', 'B', 'F', 'P', 'U', 'I', 'G', 'E', 'J', 'L', 'H', 'T', 'A', 'W', 'S',
            'O', 'M', 'N', 'K', 'C', 'Y', 'Q' };

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

    public boolean pesquisarTp(String str) {
        return pesquisarTp(raiz, str);
    }

    public boolean pesquisarTp(No i, String str) {
        Boolean resp = false;
        if (i != null) {
            caminharEmOrdem(i.esq);
            System.out.println("ESQ");
            resp = pesquisar(str, i.outro);
            if (!(resp)) {
                System.out.println("DIR");
                caminharEmOrdem(i.dir);
            }
        }
        return resp;
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
            // caminharEmOrdem2(i.outro);
            System.out.println(i.getLetra());
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
