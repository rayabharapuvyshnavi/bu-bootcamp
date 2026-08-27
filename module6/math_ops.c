#include <stdio.h>

int sum(int a, int b);
int product(int a , int b);
void print_math(int a, int b);

int main(){

    int a;
    int b;

    printf("Enter 1st number: ");
    scanf("%d", &a);
    printf("Enter 2nd number: ");
    scanf("%d", &b);

    print_math(a,b);
    return 0;
}


int sum(int a, int b){
    return a + b;
}

int product(int a, int b){
    return a * b;
}

void print_math(int a, int b){
    printf("Sum: %d\n" , sum(a, b) );
    printf("Product: %d\n", product(a,b));
}