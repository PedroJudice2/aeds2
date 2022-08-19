#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

#define nDeStrings 1000
#define tam 100

bool isfim(char *a);
bool ispal(char *a);
void imprimir (char *a);


int main (void) {

char str[nDeStrings][tam + 1];
int y = 0; // tamanho string
char teste[100];
    // pegar strings


    do {
        fgets(teste, tam, stdin);
        teste[strcspn(teste, "\r\n")] = 0;
        strcpy(str[y], teste);
    } while (isfim(str[y++]));
    y--; //desnconsiderar fim

      for (int i = 0; i < y; i++) {
        imprimir(str[i]);
    } 

}

bool isfim(char *a) {
    if (a[0] == 'F' && a[1] == 'I' && a[2] == 'M'){
    return false;
    }
    return true;
}

void imprimir (char *a) {
    if (ispal(a) == true) {
    printf("SIM\n");
    } else {
    printf("NAO\n");
    }
}

bool ispal(char *a) {
    for (int i = 0; i < (strlen(a) / 2); i++) {
        if (a[i] != a[strlen(a) - i - 1]) {
            return false;
        }
    } 
    return true;
}