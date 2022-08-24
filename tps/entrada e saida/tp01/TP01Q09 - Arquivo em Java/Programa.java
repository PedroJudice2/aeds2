import java.util.*;
import java.io.File;  
import java.io.IOException;  

class Programa {
    public static void main (String[] args) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
              System.out.println("Arquivo criado: " + myObj.getName());
            } else {
              System.out.println("Arquivo ja existe");
            }
          } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
          }
        }
    }
