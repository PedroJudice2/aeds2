#include <stdio.h>
#include <stdbool.h>

#define nDeStrings 1000
#define tam 400

char **str_split(char *a_str, const char a_delim);
typedef struct
{
    char *month;
    int year;
} Date;
typedef struct
{
    int app_id;
    char *name;
    Date release_date;
    char *owners;
    int age;
    float price;
    int dlcs;
    char **languages;
    char *website;
    bool windows;
    bool mac;
    bool linus;
    float upvote;
    int avg_pt;
    char *developers;
    char **genres;
} Game;

int main(void)
{
    FILE *input = fopen("/tmp/games.csv", "r");

    char str[nDeStrings][tam + 1];
    While(fread())
}

char **str_split(char *a_str, const char a_delim)
{
    char **result = 0;
    size_t count = 0;
    char *tmp = a_str;
    char *last_comma = 0;
    char delim[2];
    delim[0] = a_delim;
    delim[1] = 0;

    /* Count how many elements will be extracted. */
    while (*tmp)
    {
        if (a_delim == *tmp)
        {
            count++;
            last_comma = tmp;
        }
        tmp++;
    }

    /* Add space for trailing token. */
    count += last_comma < (a_str + strlen(a_str) - 1);

    /* Add space for terminating null string so caller
       knows where the list of returned strings ends. */
    count++;

    result = malloc(sizeof(char *) * count);

    if (result)
    {
        size_t idx = 0;
        char *token = strtok(a_str, delim);

        while (token)
        {
            assert(idx < count);
            *(result + idx++) = strdup(token);
            token = strtok(0, delim);
        }
        assert(idx == count - 1);
        *(result + idx) = 0;
    }

    return result;
}