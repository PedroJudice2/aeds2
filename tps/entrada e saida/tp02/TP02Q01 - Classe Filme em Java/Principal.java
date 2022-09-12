import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

class Principal {

    public static boolean isfim(String b) {
        if (b.charAt(0) == 'F' && b.charAt(1) == 'I' && b.charAt(2) == 'M' && b.length() == 3)
            return false;
        return true;

    }

    public static void buscar(String str, List<Game> list) {
        Comparator<Game> c = new Comparator<Game>() {
            public int compare(Game u1, Game u2) {
                return u1.getApp_id().compareTo(u2.getApp_id());
            }
        };
        Game x = new Game();
        x.setApp_id(str);
        int y = Collections.binarySearch(list, x, c);
        System.out.println(list.get(y));
    }

    public static List<Game> ler() {
        List<Game> list = new ArrayList<Game>();
        // abrir arquivo
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"))) {

            // copiar arquivo para memoria
            String[] str = new String[4500];
            int x = 0;
            str[x] = br.readLine();
            while (str[x] != null) {
                Game line = new Game();
                String[] vect = str[x].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                line.setApp_id(vect[0]);
                line.setName(vect[1]);
                line.setRelease_date(vect[2]);
                line.setOwners(vect[3]);
                line.setAge(vect[4]);
                line.setPrice(vect[5]);
                line.setDlcs(vect[6]);
                line.setLanguages(vect[7]);
                line.setWebsite(vect[8]);
                line.setWindows(vect[9]);
                line.setMac(vect[10]);
                line.setLinux(vect[11]);
                line.setUpvote(vect[12], vect[13]);
                line.setAvg_pt(vect[14]);
                line.setDevelopers(vect[15]);
                line.setGenres(vect[16]);

                // adicionar jogo na lista
                list.add(line);
                str[++x] = br.readLine();
            }
            // sortear lista
            Collections.sort(list, new Comparator<Game>() {
                public int compare(Game o1, Game o2) {
                    if (o1.getApp_id() == o2.getApp_id())
                        return 0;
                    return o1.getApp_id() < o2.getApp_id() ? -1 : 1;
                }
            });

            /*
             * for (Game g : list) {
             * System.out.println(g.getWebsite());
             * }
             */

            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        ler();

        Scanner sc = new Scanner(System.in);
        String[] str = new String[1000];
        int y = 0; // numero de strings
        // ler palavras
        do {
            str[y] = sc.nextLine();
        } while (isfim(str[y++]));
        y--; // desconsiderar FIM
        sc.close();

        for (int i = 0; i < y; i++)
            buscar(str[i], ler());

    }
}

class Game {
    // atributos
    private int app_id = 0;
    private String name = "null";
    private Date release_date = null;
    private String owners = "null";
    private int age = 0;
    private float price = 0;
    private int dlcs = 0;
    private String[] languages;
    private String website = "null";
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvote = 0;
    private int avg_pt = 0;
    private String developers = "null";
    private String[] genres;

    // metodos get e set
    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        if (app_id.isEmpty())
            this.app_id = 0;
        else {
            this.app_id = Integer.valueOf(app_id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty())
            this.name = "null";
        else {
            this.name = name;
        }

    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        if (release_date.isEmpty())
            this.release_date = null;
        else {
            try {
                String strNew = release_date.replaceAll("^\"|\"$", "");
                SimpleDateFormat fmt = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                this.release_date = fmt.parse(strNew);
            } catch (ParseException e) {
                try {
                    SimpleDateFormat fmt = new SimpleDateFormat("MMM yyyy", Locale.US);
                    this.release_date = fmt.parse(release_date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        if (owners.isEmpty())
            this.owners = "null";
        else {
            this.owners = owners;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age.isEmpty())
            this.age = 0;
        else {
            this.age = Integer.valueOf(age);
        }

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(String price) {
        if (price.isEmpty())
            this.price = 0;
        else {
            this.price = Float.valueOf(price);
        }

    }

    public int getDlcs() {
        return dlcs;
    }

    public void setDlcs(String dlcs) {
        if (dlcs.isEmpty())
            this.dlcs = 0;
        else {
            this.dlcs = Integer.valueOf(dlcs);
        }
    }

    public String getLanguages() {
        if (languages == null)
            return "null";

        int iMax = languages.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0;; i++) {
            b.append(String.valueOf(languages[i]));
            if (i == iMax)
                return b.toString();
            b.append(",");
        }
    }

    public void setLanguages(String languages) {
        String str = languages.replaceAll("'", "").replaceAll("^\"|\"$", "");
        String[] array = str.split("\\,");
        this.languages = array;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (website.isEmpty())
            this.website = "null";
        else {
            this.website = website;
        }

    }

    public boolean getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        if (windows.isEmpty())
            this.windows = false;
        else {
            this.windows = Boolean.parseBoolean(windows);
        }
    }

    public boolean getMac() {
        return mac;
    }

    public void setMac(String mac) {
        if (mac.isEmpty())
            this.mac = false;
        else {
            this.mac = Boolean.parseBoolean(mac);
        }
    }

    public boolean getLinux() {
        return linux;
    }

    public void setLinux(String linux) {
        if (linux.isEmpty())
            this.linux = false;
        else {
            this.linux = Boolean.parseBoolean(linux);
        }
    }

    public float getUpvote() {
        return upvote;
    }

    public void setUpvote(String upvote, String downvote) {
        if (upvote.isEmpty() || downvote.isEmpty())
            this.upvote = 0;
        else {
            float total = Float.valueOf(upvote) + Float.valueOf(downvote);
            this.upvote = (Float.valueOf(upvote) * 100) / total;
        }

    }

    public int getAvg_pt() {
        return avg_pt;
    }

    public void setAvg_pt(String avg_pt) {
        if (avg_pt.isEmpty())
            this.avg_pt = 0;
        else {
            this.avg_pt = Integer.valueOf(avg_pt);
        }

    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        if (developers.isEmpty())
            this.developers = "null";
        else {
            String str = developers.replaceAll("^\"|\"$", "");
            this.developers = str;
        }

    }

    public String getGenres() {
        if (genres == null)
            return "null";

        int iMax = genres.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0;; i++) {
            b.append(String.valueOf(genres[i]));
            if (i == iMax) {
                b.append("]");
                return b.toString();
            }

            b.append(", ");
        }
    }

    public void setGenres(String genres) {
        String str = genres.replaceAll("^\"|\"$", "");
        String[] array = str.split("\\,");
        this.genres = array;
    }

    public String getTime() {
        String resp = "null";
        if (avg_pt == 0) {
            resp = "null";
        } else if (avg_pt / 60 == 0) {
            resp = String.format("%dm", avg_pt % 60);
        } else if (avg_pt % 60 == 0) {
            resp = String.format("%dh", avg_pt / 60);
        } else {
            resp = String.format("%dh %dm", avg_pt / 60, avg_pt % 60);
        }
        return resp;
    }

    @Override
    public String toString() {
        SimpleDateFormat DateFor = new SimpleDateFormat("MMM/yyyy", Locale.US);
        return "" + app_id + " " + name + " " + DateFor.format(release_date) + " " + owners + " " + age + " "
                + String.format(Locale.US, "%.2f", price)
                + " " + dlcs + " " + getLanguages() + " " + website + " " + windows + " " + mac + " " + linux
                + " " + String.format("%.0f%%", upvote) + " "
                + getTime()
                + " " + developers + " " + getGenres();
    }

}