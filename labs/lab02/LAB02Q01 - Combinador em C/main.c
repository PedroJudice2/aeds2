#include <stdio.h>
#include <string.h>

#define nDeStrings 1000
#define tam 350



int main(void) {

  // definir vetor de strings
  char pri[100];
  char sec[100];
  // ler strings
  
  while (scanf("%s %s", pri, sec) != EOF) {
    int x = 0;
    while (x < strlen(pri) || x < strlen(sec)) {
      if (x < strlen(pri)) {
      printf("%c", pri[x]);
      }
      if(x < strlen(sec)) {
      printf("%c", sec[x]);
      }
      x++;
    }
    printf("\n");
  }

}