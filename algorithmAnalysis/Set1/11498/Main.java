import java.util.Scanner;

class Main {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while(!sc.hasNext("0")){
           int numberOfSets = Integer.parseInt(sc.next());
           int testX = Integer.parseInt(sc.next());
           int testY = Integer.parseInt(sc.next());

           for(int i = 0; i < numberOfSets; i++){
               int compX = Integer.parseInt(sc.next());
               int compY = Integer.parseInt(sc.next());
               if(compX > testX && compY > testY){
                   System.out.println("NE");
               }else if(compX < testX && compY > testY){
                   System.out.println("NO");
               }else if(compX > testX && compY < testY){
                   System.out.println("SE");
               }else if(compX < testX && compY < testY){
                   System.out.println("SO");
               }else{
                   System.out.println("divisa");
               }
           }

       }
   }
}
