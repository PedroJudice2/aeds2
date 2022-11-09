import java.util.Scanner;

class Perfil {
    String nome;
    Boolean opcao;

    Perfil(String nome, String op) {
        if (op.compareTo("YES") == 0) {
            opcao = true;
        } else {
            opcao = false;
        }
        this.nome = nome;
    }

}

class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        String[] pessoa = new String[2];
        Perfil[] agenda1 = new Perfil[30];
        Perfil[] agenda2 = new Perfil[30];
        String amigoHabbay = "";
        int index1 = 0;
        int index2 = 0;
        while (!(isFim(linha))) {
            pessoa = linha.split(" ");
            if (pessoa[1].compareTo("YES") == 0) {
                if (pessoa[0].length() > amigoHabbay.length()) {
                    amigoHabbay = pessoa[0];
                }
                if (!(possui(agenda1, pessoa[0], index1)))
                    agenda1[index1++] = new Perfil(pessoa[0], pessoa[1]);
            } else {
                if (!(possui(agenda2, pessoa[0], index2)))
                    agenda2[index2++] = new Perfil(pessoa[0], pessoa[1]);
            }
            linha = sc.nextLine();
        }
        bubbleSort(agenda1, index1);
        bubbleSort(agenda2, index2);

        for (int i = 0; i < index1; i++) {
            System.out.println(agenda1[i].nome);
        }
        for (int i = 0; i < index2; i++) {
            System.out.println(agenda2[i].nome);
        }

        System.out.println();
        System.out.println("Amigo do Habbay: ");
        System.out.println(amigoHabbay);

        sc.close();
    }

    public static void bubbleSort(Perfil[] array, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j].nome.compareTo(array[j + 1].nome) > 0) {
                    Perfil temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static boolean isFim(String linha) {
        if (linha.length() == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M') {
            return true;
        }
        return false;
    }

    public static boolean possui(Perfil[] array, String nome, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i].nome.equals(nome)) {
                return true;
            }
        }
        return false;

    }

}