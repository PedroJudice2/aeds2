#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// create struct for tree
typedef struct node
{
    int val;
    struct node *left;
    struct node *right;
} node;

// create root for tree
node *root = NULL;
node *root2 = NULL;

// functions prototypes
void insert(int element);
void insert2(int element);
node *insertNode(int element, node *i);
void printTree(void);
void printTreeReal(node *i);
int treeHeightNode(void);
int treeHeightCountNode(node *i);
int treeHeightEdge(void);
int treeHeightCountEdge(node *i, int height);
int NodeSum(void);
int NodeSumCount(node *i);
int evenNum(void);
int evenNumCount(node *i);
bool compareTree(void);
bool compareTreeReal(node *i, node *j);
bool dividableBy11(void);
bool dividableBy11Real(node *i);
void TreeSort(int *array);
void TreeSortReal(node *i, int *array, int index);

int main(void)
{
    int numbers[] = {5, 3, 7, 2, 4, 6, 8, 1, 9};
    int numbers2[] = {5, 3, 7, 2, 4, 6, 8, 1};

    int arr_len = sizeof(numbers) / sizeof(numbers[0]);

    for (int i = 0; i < arr_len; i++)
    {
        insert(numbers[i]);
    }

    printf("Vetor antes da ordenação: ");
    for (int i = 0; i < 8; i++)
    {
        printf("%d, ", numbers2[i]);
    }

    TreeSort(numbers2);
    printf("\nVetor depois da ordenação: ");
    for (int i = 0; i < 8; i++)
    {
        printf("%d, ", numbers2[i]);
    }
}

void insert(int element)
{
    root = insertNode(element, root);
}

void insert2(int element)
{
    root2 = insertNode(element, root2);
}

node *insertNode(int element, node *i)
{
    if (i == NULL)
    {
        i = malloc(sizeof(node));
        i->val = element;
    }
    else
    {
        if (element > i->val)
        {
            i->right = insertNode(element, i->right);
        }
        else if (element < i->val)
        {
            i->left = insertNode(element, i->left);
        }
        else
        {
            printf("Elemento presente na arvore");
            exit(3);
        }
    }
    return i;
}

void printTree(void)
{
    printTreeReal(root);
}

void printTreeReal(node *i)
{
    if (i != NULL)
    {
        printTreeReal(i->left);
        printf("Value: %i\n", i->val);
        printTreeReal(i->right);
    }
}

int treeHeightNode(void)
{
    return treeHeightCountNode(root);
}

int treeHeightCountNode(node *i)
{
    if (i == NULL)
    {
        return 0;
    }

    int left = treeHeightCountNode(i->left);
    int right = treeHeightCountNode(i->right);

    if (left > right)
    {
        return left + 1;
    }
    else
    {
        return right + 1;
    }
}

int treeHeightEdge(void)
{
    if (root != NULL)
    {
        return treeHeightCountEdge(root, 0);
    }
    exit(9);
}

int treeHeightCountEdge(node *i, int height)
{
    if (i == NULL)
    {
        height--;
    }
    else
    {
        int left = treeHeightCountEdge(i->left, height++);
        int right = treeHeightCountEdge(i->right, height++);
        if (left > right)
        {
            height = left;
        }
        else
        {
            height = right;
        }
    }
    return height;
}

int NodeSum(void)
{
    return NodeSumCount(root);
}

int NodeSumCount(node *i)
{
    int count = 0;
    if (i != NULL)
    {
        count = i->val + NodeSumCount(i->left) + NodeSumCount(i->right);
    }
    return count;
}

int evenNum(void)
{
    return evenNumCount(root);
}

int evenNumCount(node *i)
{
    int count = 0;
    if (i != NULL)
    {
        int count = 0;
        if (i != NULL)
        {
            count = ((i->val % 2 == 0) ? 1 : 0) + NodeSumCount(i->left) + NodeSumCount(i->right);
        }
    }
    return count;
}

bool compareTree(void)
{
    if (root != NULL && root2 != NULL)
    {
        return compareTreeReal(root, root2);
    }
    exit(9);
}

bool compareTreeReal(node *i, node *j)
{
    bool anwser = true;
    if (i != NULL && j != NULL)
    {
        if (i->val == j->val)
        {
            anwser = compareTreeReal(i->left, j->left);
            anwser = compareTreeReal(i->right, j->right);
        }
        else
        {
            anwser = false;
        }
    }

    else if (i != NULL)
    {
        anwser = false;
    }
    else if (j != NULL)
    {
        anwser = false;
    }

    return anwser;
}

bool dividableBy11(void)
{
    if (root != NULL)
    {
        return dividableBy11Real(root);
    }
    exit(9);
}

bool dividableBy11Real(node *i)
{
    bool anwser = false;
    if (i != NULL)
    {
        if (i->val % 11 != 0)
        {
            anwser = dividableBy11Real(i->left);
            anwser = dividableBy11Real(i->right);
        }
        else
        {
            anwser = true;
        }
    }

    return anwser;
}

void TreeSort(int *array)
{
    int arr_len = sizeof(array) / sizeof(array[0]);
    for (int i = 0; i < arr_len; i++)
    {
        insert2(array[i]);
    }

    TreeSortReal(root2, array, 0);
}

void TreeSortReal(node *i, int *array, int index)
{
    if (i != NULL)
    {
        TreeSortReal(i->left, array, index);
        array[index++] = i->val;
        TreeSortReal(i->right, array, index);
    }
}