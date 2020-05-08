#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]){
	while(1){
		int  input;
		scanf("%d", &input);
		if(input <= 0){
			printf("END OF OUTPUT\n");
			break;
		}
		if(input > 180){
			printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", input);
			printf("**********************************************************************\n");
		continue;
		}
		int perm = 0;
		int comb = 0;
		int i,j,k;
		int count = 0;
		for(i = 0; i <= 60; i++){
			if(i > 20){
				if(i % 2 != 0 && i % 3 != 0){
					continue;
				}else if(i > 40 && i % 3 != 0 && i != 50){
					continue;
				}
			}
			for(j = 0; j <=60; j++){
				if(j > 20){
					if(j % 2 != 0 && j % 3 != 0){
						continue;
					}else if(j > 40 && j % 3 != 0 && j != 50){
						continue;
					}
				}
				for(k = 0; k <=60; k++){
					if(k>20 ){
						if(k % 2 != 0 &&  k % 3 != 0){
							continue;
						}else if(k > 40 && k % 3 != 0 && k != 50){
							continue;
						}
					}
					if(i + j + k == input){
						perm++;
						if(i == j && j == k){
							comb++;
						}else if(i == j || j == k || i == k){
							count++;
						}
					}
				}
			}
		}
		comb += ((perm-comb-count)/6);
		comb += (count/3);
		if(perm == 0){	
			printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", input);
			printf("**********************************************************************\n");
		}else {
			printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", input, comb);
			printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", input, perm);
			printf("**********************************************************************\n");
		}
	}
}
