#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <unistd.h>
#include <stdlib.h>

void printBits(size_t const size, void const * const);
void printByte(unsigned char const * const);

void clearInputBuffer() {
	char c;
	while((c = getchar()) != '\n' && c != EOF)
		/* discard */ ;
}

int  main(int argc, char* argv[]){
	int input;
	double doubleval;
	
	while(1){

        printf("1. Display bits for double\n2. Exit\n");
                scanf("%d", &input);
                fflush(stdin);

		if (input==1){
			printf("Enter a double value: \n");
			if(scanf("%lf", &doubleval) != 1){
				printf("bad value\n");
				clearInputBuffer();			
				continue;			
			}
			//printf("float: %d\n", doubleval);
			printBits(sizeof(doubleval), &doubleval);
			input=0;
		}
		else if(input==2){
			exit(1);
		}else
			printf("invalid option: [%d]\n", input);
	}

	return 0;
}


void printBits(size_t const size, void const * const ptr){
	unsigned char *b = (unsigned char*)ptr;
	int i;
	for(i=size-1;i>=0;i--){
		printByte(b+i);
	}
	puts("");
}

void printByte(unsigned char const * const b){
	unsigned char bit;
	int j;

	for(j=7;j>=0;j--){
		bit=(*b>>j)&1;
		printf("%u",bit);
	}
	printf("  ");
}

// End of File


