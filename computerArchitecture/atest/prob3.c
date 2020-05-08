#include <stdio.h>
#include <stdint.h>
#include <string.h>


void printBits(size_t const size, void const * const ptr){
	unsigned char *b = (unsigned char*) ptr;
	unsigned char bit;
	int i, j;

	for(i=0;i < size; i++){
		for(j=7; j >= 0; j--){
			bit = (b[i] >> j) & 1;
			printf("%u", bit);
		}
		printf(" ");
	}
	puts("");
}

int main(int argc, char* argv[]){
	int ni = -23;
	int pi = 23;
	unsigned int ui = UINT32_MAX;
	float f = 23.45f;
	const char* str = "hello";
	
	printBits(sizeof(ni), &ni);
	printBits(sizeof(pi), &pi);
	printBits(sizeof(ui), &ui);
	printBits(sizeof(f), &f);
	printBits(strlen(str), str);

	return 0;
}
