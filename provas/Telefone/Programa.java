import java.util.Scanner;

class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cel = sc.nextLine();
        StringBuilder b = new StringBuilder();
        b.append(cel);
        for (int i = 0; i < cel.length(); i++) {
            if (Character.isLetter(b.charAt(i))) {
                b.setCharAt(i, tradutor(b.charAt(i)));
            }
        }
        System.out.println(b.toString());
    }

    public static char tradutor(char letra) {
        char resp = '\0';
        char a = 'a';
        letra = Character.toLowerCase(letra);
        if (Character.compare(letra, a) == 0 || Character.compare(letra, 'b') == 0
                || Character.compare(letra, 'c') == 0) {
            resp = '2';
        } else if (Character.compare(letra, 'd') == 0 || Character.compare(letra, 'e') == 0
                || Character.compare(letra, 'f') == 0) {
            resp = '3';
        } else if (Character.compare(letra, 'g') == 0 || Character.compare(letra, 'h') == 0
                || Character.compare(letra, 'i') == 0) {
            resp = '4';
        } else if (Character.compare(letra, 'j') == 0 || Character.compare(letra, 'k') == 0
                || Character.compare(letra, 'l') == 0) {
            resp = '5';
        } else if (Character.compare(letra, 'm') == 0 || Character.compare(letra, 'n') == 0
                || Character.compare(letra, 'o') == 0) {
            resp = '6';
        } else if (Character.compare(letra, 'p') == 0 || Character.compare(letra, 'q') == 0
                || Character.compare(letra, 'r') == 0 || Character.compare(letra, 's') == 0) {
            resp = '7';
        } else if (Character.compare(letra, 't') == 0 || Character.compare(letra, 'u') == 0
                || Character.compare(letra, 'v') == 0) {
            resp = '8';
        } else if (Character.compare(letra, 'w') == 0 || Character.compare(letra, 'x') == 0
                || Character.compare(letra, 'y') == 0 || Character.compare(letra, 'z') == 0) {
            resp = '9';
        }
        return resp;
    }
}