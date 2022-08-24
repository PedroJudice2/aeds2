#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>

#define nDeStrings 1000
#define tam 400

bool isfim(char *a);
void is(char *texto);
char *isvogal(char *texto);
char *isconsu(char *texto);
char *isint(char *texto);
char *isreal(char *texto);

int main (void) {

char str[nDeStrings][tam + 1];
int y = 0; // tamanho string
char teste[tam + 1];
    // pegar strings


    do {
        fgets(teste, tam, stdin);
        teste[strcspn(teste, "\r\n")] = 0;
        strcpy(str[y], teste);
    } while (isfim(str[y++]));
    y--; //desnconsiderar fim

      for (int i = 0; i < y; i++) {
        is(str[i]);
    } 

}

bool isfim(char *a) {
    if (a[0] == 'F' && a[1] == 'I' && a[2] == 'M'){
    return false;
    }
    return true;
}

void is(char *texto) {
    for(int i = 0; texto[i]; i++){
  texto[i] = tolower(texto[i]);
}
    printf("%s ", isvogal(texto));
    printf("%s ", isconsu(texto));
    printf("%s ", isint(texto));
    printf("%s\n", isreal(texto));
}

char *isvogal(char *texto) {
    for (int i = 0; i < strlen(texto); i++) {
        if (texto[i] != 'a' && texto[i] != 'e' && texto[i] != 'i' && texto[i] != 'o' && texto[i] != 'u') {
            return ("NAO");
        }
     }
     return ("SIM");
}

char *isconsu(char *texto) {
    for (int i = 0; i < strlen(texto); i++) {
           if (!(texto[i] >= 'a' && texto[i] <= 'z') || (texto[i] == 'a' || texto[i] == 'e' || texto[i] == 'i' || texto[i] == 'o' || texto[i] == 'u')) {
               return ("NAO");
           }
        }
        return ("SIM");
}

char *isint(char *texto) {
     for (int i = 0; i < strlen(texto); i++) {
           if (!(texto[i] >= '0' && texto[i] <= '9')) {
            return ("NAO");
           }
        }
        return ("SIM");
}

char *isreal(char *texto) {
    int count = 0;
        for (int i = 0; i < strlen(texto); i++) {
           if (!(((texto[i] >= '0' && texto[i] <= '9') || texto[i] == ',' || texto[i] == '.') && count < 2)) {
            return ("NAO");
           }
           if (texto[i] == ',' || texto[i] == '.') {
            count++;
           }
        }

        return ("SIM");
}