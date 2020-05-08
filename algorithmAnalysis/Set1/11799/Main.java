import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line;
        int max;
        int numOfCases = Integer.parseInt(sc.next());
        sc.nextLine();
        for(int i = 1; i <= numOfCases; i++){
            max = 0;
            line = sc.nextLine();
            Scanner lineSc = new Scanner(line);
            while(lineSc.hasNext()){
                int temp = Integer.parseInt(lineSc.next());
                if(temp > max ){
                   max = temp;
                }
            }
            System.out.println("Case " + i + ": " + max);
        }
    }
}
