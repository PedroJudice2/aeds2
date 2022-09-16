import java.util.*;

class Programa {

    public static void main(String args[]) {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        String str;
        // ler numeros
        while (sc.hasNext()) {
            str = sc.nextLine();
            String[] splitStr = str.split("\\s+");
            StringBuilder inverso = new StringBuilder();
            for (int i = Integer.valueOf(splitStr[0]); i <= Integer.valueOf(splitStr[1]); i++) {
                System.out.print(i);
                inverso.append(i);
            }
            inverso.reverse();
            System.out.println(inverso);
            x++;
        }
        sc.close();
    }

}