import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < t; i++){
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            if(a > b){
                System.out.println(">");
            }else if(a < b){
                System.out.println("<");
            }else{
                System.out.println("=");
            }
        }
    }
}
