#include <stdio.h>
#include <stdlib.h>

int strlen(char* p);
char* strdup(char* p);
void strcpy(char* p, char* q);
void strncpy(char* p, char* q, int n);
int strcmp(char* p, char* q);
void strcat(char* p, char* q);
char ignorecase(char p);


int main(){
	char p[] = "hello";
	char q[] = "World";
	char r[] = "World";
	char t[] = "Hello";

	//Test strlen
	printf("%d\n", strlen(p));

	//Test strdup
	char* pa = strdup(p);

	printf("p = %p pa = %p\n", p, pa);//strdup(p));
	printf("pa = %s\n", pa);

	//Test strcpy
	char cpy[] = "Hello";
	strcpy(cpy,q);
	printf("Test strcpy: p = %s\n", cpy);
	
	//Test strncpy
	char cpyn[] = "Hello";
	strncpy(cpyn,q,2);
	printf("Test strncpy: p = %s\n", cpyn);
	
	//Test strcmp
	printf("Test strcmp smaller: %d\n", strcmp(p,q));
	printf("Test strcmp larger: %d\n", strcmp(q,p));
	printf("Test strcmp equal: %d\n", strcmp(q,r));
	printf("Test strcmp lowercase != uppercase: %d\n", strcmp(t,p));

	//Test strcat
	char cat[20] = "Hello";
	printf("%d\n", strlen(cat));
	printf("Size1: %d\n", sizeof(cat));
	strcat(cat,q);
	printf("Test strcat: p + q = %s\n", cat);

	return 1;	
}

int strlen(char* p){
	int i = 0;
	while(*p != '\0'){
		i++;
		p++;
	}
	return i;
}

char* strdup(char* p){
	int count = 0;
	while(*(p+count) != '\0'){
		count++;
	}
	// Allocate space after determining size
	char* pa = (char *) malloc(count);

	// Then copy
	while(*p != '\0'){
		*pa = *p;
		p++;
		pa++;
	}
	return (pa-count);
}

void strcpy(char* p, char* q){
	if(strlen(p) >= strlen(q)){
		while(*q != '\0'){
			*p = *q;
			p++;
			q++;
		}

	}
}

void strncpy(char* p, char* q, int n){
	if(strlen(p) >= strlen(q)){
		char* temp = q;
		while(*q != '\0' && (q - temp) < n){
			*p = *q;
			p++;
			q++;
		}
	}
}

int strcmp(char* p, char* q){
	while(ignorecase(*p) == ignorecase(*q) && *p != '\0' && *q != '\0'){
		if(*p != *q){
			return *p - *q;
		}
		p++;
		q++;
	}
	return ignorecase(*p) - ignorecase(*q);
	
}	

void strcat(char* p, char* q){
	while(*p != '\0'){
		p++;
	}
		while(*q != '\0'){
			*p = *q;
			p++;
			q++;
		}
}


char ignorecase(char p){
	if(p >= 97 && p <= 122){
		p = p - 32;
		return p;
	}
}
	
		
