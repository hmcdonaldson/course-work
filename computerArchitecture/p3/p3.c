#include <stdio.h>
#include <string.h>

char *strstr(const char *haystack, const char *needle);
int count(const char *str1, const char *str2);
void print_matrix(int arr[3][3]);

int main(){
	
	//Test strstr
	const char *test_haystack = "adfnlhneeafgneedlekmn";
	const char *test_needle = "needle";
	char* test_strstr = strstr(test_haystack, test_needle);
	int counter = 0;
	
	printf("Test strstr: ");
	while(counter <  strlen(test_needle)){
		printf("%c", *test_strstr);
		counter++;
		test_strstr++;
	}
	printf("\n");


	//Test count
	const char *test_str1 = "rafanblbanananlkanan";
	const char *test_str2 = "anan";
	printf("Test count: %d\n", count(test_str1, test_str2));


	//Test print_matrix
	int arr[3][3] = {{1,2,3},{4,5,6},{7,8,9}};
	print_matrix(arr); 
	return 1;
}

char *strstr(const char *haystack, const char *needle){
	int count = 0;
	while(*haystack != '\0'){
		if(*haystack == *needle){
			haystack++;
			needle++;
			count++;
		}else{
			haystack = haystack - count + 1;
			needle = needle - count;
			count = 0;
		}

		if(count == strlen(needle - count)){
			return (haystack - count);
		}
	}
	return NULL;		
}	

int count(const char *str1, const char *str2){
	int count = 0;
	int match_count = 0;
	while(*str1 != '\0'){
		if(*str1 == *str2){
			str1++;
			str2++;
			count++;
		}else{
			str1 = str1 - count + 1;
			str2 = str2 - count;
			count = 0;
		}
		
		if(count == strlen(str2 - count)){
			match_count++;
			str1 = str1 - count + 1;
			str2 = str2 - count;
			count = 0;
		}
	}
	return match_count;
}

void print_matrix(int arr[3][3]){
	int i, j;
	for(i = 0; i < 3; i++){
		for(j = 0; j < 3; j++){
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
}
