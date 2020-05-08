// Hunter McDonaldson 1/18/2019

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print_matrix(int arr[], int k);

int main(int argc, char* argv[]){
	int k = (int) strtol(argv[1], NULL, 10);
	int i = (int) strtol(argv[2], NULL, 10);
	int id = (int) strtol(argv[3], NULL, 10);
	int array_size = k*k;
	int temp;
	char* fill = "false";
	int count;
	int *arr = (int*) malloc(array_size * sizeof(int));
	memset(arr, 0, array_size * sizeof(int));
	arr[i] = id;
	print_matrix(arr, k);

	while (fill != "true"){
		count = 0;
		for(temp = 0; temp < array_size; temp++){
			if(arr[temp] == id){
				count++;
				if(count == array_size){
					fill = "true";
				}
				continue;
			}
			
			if(temp+1 < array_size && temp%k != (k-1) && arr[temp+1] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			}
			if(temp-1 >= 0 && temp%k != 0 && arr[temp-1] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			}
			if(temp+k < array_size && arr[temp+k] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			}
			if(temp-k >= 0 && arr[temp-k]){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			}
			if(temp+k-1 < array_size && temp%k != 0&& arr[temp+k-1] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			} 
			if(temp+k+1 < array_size && temp%k != (k-1) && arr[temp+k+1] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			} 
			if(temp-k-1 >= 0 && temp%k != 0 && arr[temp-k-1] == id){
				arr[temp] = id;
				print_matrix(arr,k);
				continue;	
			} 
			if(temp-k+1 >= 0 && temp%k != (k-1) && arr[temp-k+1] == id){	
				arr[temp] = id;
				print_matrix(arr,k);
				continue;
			}
		}
	}

	free(arr);

	return 0;
}

void print_matrix(int arr[], int k){
	int i;
	int j;
	for(i = 0; i < k; i++){
		for(j = 0; j < k; j++){
			printf("%2d", arr[k*i + j]);
		}
		putchar('\n');
	}
	putchar('\n');
}
