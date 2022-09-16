import java.util.Scanner;

class Programa {

    public static Pais[] bubbleSort(Pais[] array, int count) {
        int swap = 0;
        for (int i = 0; i < count; i++) {
            swap = 0;
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j].getOuro() == array[j + 1].getOuro()) {
                    if (array[j].getPrata() == array[j + 1].getPrata()) {
                        if (array[j].getBronze() == array[j + 1].getBronze()) {
                            int compare = array[j].getPais().compareTo(array[j + 1].getPais());
                            if (compare > 0) {
                                array[j] = swap(array[j + 1], array[j + 1] = array[j]);
                                swap++;
                            }
                        } else if (array[j].getBronze() < array[j + 1].getBronze()) {
                            array[j] = swap(array[j + 1], array[j + 1] = array[j]);
                            swap++;
                        }
                    } else if (array[j].getPrata() < array[j + 1].getPrata()) {
                        array[j] = swap(array[j + 1], array[j + 1] = array[j]);
                        swap++;
                    }
                } else if (array[j].getOuro() < array[j + 1].getOuro()) {
                    array[j] = swap(array[j + 1], array[j + 1] = array[j]);
                    swap++;
                }
            }
            if (swap == 0) {
                i = 1000000;
            }
        }
        return array;
    }

    public static Pais swap(Pais itself, Pais outro) {
        return itself;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] paises = new String[n];
        Pais[] country = new Pais[n];
        Pais[] sorted = new Pais[n];
        int x = 0;
        while (sc.hasNext()) {
            paises[x] = sc.nextLine();
            String[] vect = paises[x].split(" ");
            country[x] = new Pais(vect[0], vect[1], vect[2], vect[3]);
            x++;
        }
        sorted = bubbleSort(country, x);
        for (int i = 0; i < x; i++) {
            System.out.println(sorted[i]);
        }
        sc.close();
    }
}

class Pais {
    private String pais;
    private int ouro;
    private int prata;
    private int bronze;

    Pais(String pais, String ouro, String prata, String bronze) {
        this.pais = pais;
        this.ouro = Integer.valueOf(ouro);
        this.prata = Integer.valueOf(prata);
        this.bronze = Integer.valueOf(bronze);
    }

    public String getPais() {
        return pais;
    }

    public int getOuro() {
        return ouro;
    }

    public int getPrata() {
        return prata;
    }

    public int getBronze() {
        return bronze;
    }

    @Override
    public String toString() {
        return pais + " " + ouro + " " + prata + " " + bronze;
    }
}