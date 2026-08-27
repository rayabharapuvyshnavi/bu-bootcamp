#include <stdio.h>

void swap(int *a, int *b);
void broken_swap(int a, int b);

int main(){
    int a1 = 15;
    int b1 = 70;

    printf("Pass by Reference:\n");
    printf("Before swap: x = %d  y = %d \n", a1, b1);
    swap(&a1, &b1);
    printf("After  swap: x = %d  y = %d \n", a1, b1);


    int a2 = 4;
    int b2 = 7;

    printf("Pass by Value:\n");
    printf("Before swap: x = %d  y = %d \n", a2, b2);
    broken_swap(a2, b2);
    printf("After  swap: x = %d  y = %d \n", a2, b2);

}

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}
void broken_swap(int a, int b){
    int temp = a;
    a = b;
    b = temp;
}