import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            int height = Integer.parseInt(sc.next());
            int climb = Integer.parseInt(sc.next());
            int slide = Integer.parseInt(sc.next());
            double fatigue = Double.parseDouble(sc.next());
            if (height == 0) {
                System.exit(0);
            }
            double newClimb = climb;
            double fatigueAmount = fatigue * newClimb / 100;
            int day = 1;
            double snailHeight = 0;
            String success = "failure";
            while(true){
                if(newClimb < 0){
                    break;
                }
                snailHeight += newClimb;


                if(snailHeight > height){
                    success = "success";
                    break;
                }
                snailHeight -= slide;
                newClimb -= fatigueAmount;
                if(snailHeight < 0){
                    break;
                }
                day++;
            }
            //System.out.println(success + " on day " + day);
            System.out.printf("%s on day %d%n" , success, day);
        }
    }
}
