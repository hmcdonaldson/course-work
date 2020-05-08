#include <stdio.h>

int htoi(char s[]);
unsigned setbits(unsigned x, int p, int n, unsigned y);
unsigned invert(unsigned x, int p, int n);

int  main(){
	int exercise23 = htoi("0xD19fB");
	printf("Exercise 2-3: 0xD19fB = %d\n", exercise23);

	unsigned exercise26 = setbits(85, 4, 3, 44);
	printf("Exercise 2-6: x=85 p=4 n=3 y=44 output=%d\n", exercise26);

	unsigned exercise27 = invert(170, 4, 3);
	printf("Exercise 2-7: x=170 p=4 n=3 invert=%d\n", exercise27);	

	return 0;	
}

int htoi(char s[]){
	int temp = 0;
	int digit = 0;
	int i = 0;
	if((s[i] == 48) && (s[i+1] == 88 || s[i+1] ==120)){
		i += 2;
	}
	for(i; s[i] != EOF; i++){
		if(s[i] >= '0' &&  s[i] <= '9'){
			temp = s[i] - '0';
		}else if(s[i] >= 65 && s[i] <= 70){ 
			temp = s[i] - 55; 
		}else if(s[i] >= 97 && s[i] <= 102){
			temp = s[i] - 87;
		}else{
			break;
		}
		digit = (16 * digit) + temp;
	}
	return digit;
}

unsigned setbits(unsigned x, int p, int n, unsigned y){
	return (x & (~(~(~0 << n) << (p + 1 - n)))) | (y & ~(~0 << n)) << (p + 1 - n);
}

unsigned invert(unsigned x, int p, int n){
	return (x & (~(~(~0 << n) << (p + 1 - n)))) | ((~x) & ((~(~0 << n)) << (p + 1 - n)));
}
