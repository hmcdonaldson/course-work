#include <stdio.h>

//copy input ot output

main(){
	int c;

	c = getchar();
	while((c = getchar()) != EOF) {
		putchar(c);
	}
}
