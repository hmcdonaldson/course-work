import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true) {
            int numOfPar = Integer.parseInt(sc.next());
            int budget = Integer.parseInt(sc.next());
            int numOfHotels = Integer.parseInt(sc.next());
            int numOfWeeks = Integer.parseInt(sc.next());
            if(numOfPar <= 0 || budget <= 0 || numOfHotels <= 0 || numOfWeeks <= 0){
                System.exit(0);
            }
            int lowCost = budget + 1;
            int cost;

            for (int i = 0; i < numOfHotels; i++) {
                int costPer = Integer.parseInt(sc.next());
                for (int j = 0; j < numOfWeeks; j++) {
                    if (Integer.parseInt(sc.next()) >= numOfPar){
                        cost = costPer * numOfPar;
                        if (cost < lowCost) {
                            lowCost = cost;
                        }
                    }
                }
            }
            if (lowCost <= budget) {
                System.out.println(lowCost);
            } else {
                System.out.println("stay home");
            }
        }
    }
}
