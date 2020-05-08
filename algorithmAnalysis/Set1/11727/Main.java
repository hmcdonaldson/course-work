import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.next());
        for(int i = 1; i <= testCases; i++){
            int mid = 0;
            int emp1 = Integer.parseInt(sc.next());
            int emp2 = Integer.parseInt(sc.next());
            int emp3 = Integer.parseInt(sc.next());
            if(emp1 < emp2 && emp1 > emp3 || emp1 > emp2 && emp1 < emp3){
                mid = emp1;
            }else if(emp2 < emp1 && emp2 > emp3 || emp2 > emp1 && emp2 < emp3){
                mid = emp2;
            }else{
                mid = emp3;
            }
            System.out.println("Case " + i + ": " + mid);
        }
    }
}
