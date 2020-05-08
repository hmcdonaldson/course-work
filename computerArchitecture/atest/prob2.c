#include <stdio.h>

int main(void){
	printf("%lf\n", (3.14 + 1e20) - 1e20);
	return 0;
}
