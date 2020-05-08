#include <netdb.h>
#include <errno.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

#define MAXADDRLEN 256
#define BUFLEN 128
#define INPLEN 116

extern int errno;

void print_error(char *);

int main(int argc, char *argv[]) {
	struct addrinfo *host_ai;
	struct addrinfo hint;
	int sockfd, err;
    
	if (argc != 2)
        	print_error("usage: client hostname");
    
	hint.ai_flags = 0;
    	hint.ai_family = AF_INET;
    	hint.ai_socktype = SOCK_STREAM;
    	hint.ai_protocol = 0;
    	hint.ai_addrlen = 0;
    	hint.ai_canonname = NULL;
    	hint.ai_addr = NULL;
    	hint.ai_next = NULL;

	if ((err = getaddrinfo(argv[1], "databaseserver", &hint, &host_ai)) != 0) {
		printf("getaddrinfo error: %s\n", gai_strerror(err));
		return 0;
	}

	printf("creating socket\n");
	if ((sockfd = socket(host_ai->ai_addr->sa_family, SOCK_STREAM, 0)) < 0) {
		print_error("Error creating socket");
	}
	printf("socket created\n");

	printf("attempting Connection\n");
	if (connect(sockfd, host_ai->ai_addr, host_ai->ai_addrlen) != 0) {
		printf("can't connect to %s\n", argv[1]);
		print_error("Error connecting to server");
	}
	printf("connection made...\n"); 

	
	freeaddrinfo(host_ai);
	
	char option;
	char* cInput;
	char* temp;
	long int pNum;
	char* command = "0x01";
	temp = malloc(48);
	cInput = malloc(INPLEN);
	for(;;){
		memset(cInput, 0, INPLEN);
		printf("1. Insert New Contact\n2. Exit\n");
		option = fgetc(stdin);	
		getchar();
		//scanf("%c", &option);
		//fflush(stdin);
		if(option == '1'){
			//printf("%s", cInput);
			//printf("Enter command\n");
			//memset(temp, 0, 48);
			//fgets(temp, 4, stdin);
			
			fflush(stdin);		
			if(send(sockfd, command, 4, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}

			printf("Enter first name\n");
			memset(temp, 0, 48);
			fgets(temp, 24, stdin);
			fflush(stdin);
			if(send(sockfd, temp, 24, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}
			

			printf("Enter Last name\n");
			memset(temp, 0, 48);
			fgets(temp, 48, stdin);
			fflush(stdin);
			if(send(sockfd, temp, 48, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}

			printf("Enter email\n");
			memset(temp, 0, 48);
			fgets(temp, 36, stdin);
			fflush(stdin);
			if(send(sockfd, temp, 36, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}

			printf("Enter phone number\n");
			memset(temp, 0, 48);
			fgets(temp, 12, stdin);
			fflush(stdin);
			pNum = strtol(temp, NULL, 10);
			printf("%ld\n", pNum);
			if(send(sockfd, &pNum, 8, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}


			if(recv(sockfd, command, 4, 0) < 0){
				printf("Error receiving: %s\n", strerror(errno));
			}
			printf("%s\n", command);
			
				
			/*if(send(sockfd, cInput, 116, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}*/
		}
		if(option == '2'){
			cInput = "exit";
			if(send(sockfd, cInput, 24, 0) < 0){
				printf("Error sending: %s\n", strerror(errno));
			}
			exit(1);
		}
	}
	int n;
	int token;
	/*n = recv(sockfd, &token, 4, 0);

	if (n > 0) 
		printf("from server [%d]\n", token);
   	else {
		printf("recv returned: %d\n", n); 
       		print_error("recv error");
	}*/

	close(sockfd);
	
    	exit(1);
}


void print_error(char *str) {
	printf("%s: %s\n", str, strerror(errno));
	exit(1);
}


// END OF FILE	
