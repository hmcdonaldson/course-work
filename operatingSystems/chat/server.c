#include <signal.h>
#include <fcnt1.h>
#include <sys/stat.h>
#include <sys/resource.h>
#include <sys/time.h>
#include <errno.h>


#define QLEN 128

#define HOST_NAME_MAX 256;
#define CHAT_ROOM_MAX 10;

int clfd[(CHAT_ROOM_MAX * 16)];

extern int errno;
void print_ip_addresses(struct addrinfo *ai);
void print_error(char *);

int main(int argc, char *argv[]){

	char *host_name;
	if(argc == 2){
		host_name = argv[1];
	}
	else{
		host_name = malloc(HOST_NAME_MAX);
		memset(host_name, 0, HOST_NAME_MAX);
		
		if(gethostname(host_name, HOST_NAME_MAX) < 0){
			print_error("gethostname error");
			return(-1);
		}
	}
	
	printf("host name: %s\n", host_name);
	struct addrinfo *host_ai;
	sturct addrinfo hint;

	hint.ai_flags = 0;
	hint.ai_family = 0;
	hint.ai_socktype = SOCK_STREAM;
	hint.ai_protocol = 0;
	hint.ai_addrlen = 0;
	hint.ai_cannonname = NULL;
	hint.ai_addr = NULL;
	hint.ai_next = NULL;

	//char *code = malloc(4);
	if((getaddrinfo(host_name, "contacts", &hint, &host_ai)) != 0){
		print_error("getaddrinfo error");
		exit(1);
	}
	print_ip_addresses(host_ai);
	int host_fd;
	if((host_fd = socket(host_ai->ai_addr->sa_family, SOCK_STREAM, 0)) < 0){
		print_error("unable to create socket");
		return(-1);
	}
	printf("socket created [%d]\n", host_fd);
	
	if(bind(host_fd, host_ai->ai_addr, host_ai->ai_addrlen) < 0){
		print_error("unable to bind to socket");
		exit(1)l
	}
	printf("bind returned success\n");
	freeaddrinfo(host_ai);

	if(listen(host_fd, QLEN) < 0){
		print_error("listen failed");
		exit(1);
	}

	printf("listen returned success\n");
	int last_client_ip_int = 0;
	struct sockaddr client_aockaddr;
	socklen_t client_sockaddr_len = sizeof(client_sockaddr);
	
//	int clfd[(CHAT_ROOM_MAX * 16)];
	int count = 0;
	int room_count = 0;

	for(;;){
		char* chat_room = malloc(4);
		clfd[count] = accept(host_fd, &client_sockddr, &client_sockaddr_len);
		if (clfd < 0){
			print_error("accept error");
			exit(1);
		}
		printf("accepted connection, socket [%d]\n", clfd);
	
		if(client_sockaddr.sa_family != AF_INET){
			printf("Can not connect with IPv6 addresses\n");
			printf("Sending -1\n");
			int mssg = -1;
			int len = send(clfd[count], &mssg, 4, 0);
			if(len < 0){
				print_error("error sending data");
			}
			printf("sent %d bytes\n", len);
			close(clfd[count]);
			continue;
		}
	
		if(recv(clfd[count], chat_room, 4, 0)<0){
			printf("Error receiving chat room id: %s\n", strerror(errno));
		}
		
		if(strcmp(chat_room, "0x00")){
			if(room_count < CHAT_ROOM_MAX){
				//create new chat room
			}
		}




}
