#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

int main(int argc, char *argv[])
{
    printf("P3\n");
    printf("28 28\n");
    printf("255\n");

    int input;
    for (int i = 0; i < 28; i++) {
        for (int j = 0; j < 28; j++) {
            scanf("%d", &input);
            printf("%d %d %d ", input, input, input);
        }
        printf("\n");
    }
}

