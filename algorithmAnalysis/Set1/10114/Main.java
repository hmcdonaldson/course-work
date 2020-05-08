import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            int months = Integer.parseInt(sc.next());
            double downPay = Double.parseDouble(sc.next());
            double loanAmount = Double.parseDouble(sc.next());
            double carVal = downPay + loanAmount;
            double payment = loanAmount / months;
            if (months < 0) {
                System.exit(0);
            }
            int numOfDeprecRecords = Integer.parseInt(sc.next());


            double prevRate = 0;
            int monthCount = 0;
            int done = 0;
            int lessThanWorth = 0;
            for (int i = 0; i < numOfDeprecRecords; i++) {
                int deprecMonth = Integer.parseInt(sc.next());
                while(deprecMonth != monthCount){
                    carVal = carVal * (1-prevRate);
                    if(monthCount > 0) {
                        loanAmount -= payment;
                    }
                    monthCount++;
                    if(loanAmount < carVal && done == 0){
                        lessThanWorth = monthCount;
                        done = 1;
                    }
                }
                double rate = Double.parseDouble(sc.next());
                carVal = carVal * (1-rate);
                prevRate = rate;
                loanAmount -= payment;
                monthCount++;
                if(loanAmount < carVal && done == 0){
                    lessThanWorth = monthCount;
                    done = 1;
                }
            }
            while(monthCount < months){
                carVal = carVal * (1-prevRate);
                monthCount++;
                loanAmount -= payment;
                if(loanAmount < carVal && done == 0) {
                    lessThanWorth = monthCount;
                    done = 1;
                }
            }
            if(lessThanWorth == 1){
                System.out.println(lessThanWorth + " month");
            }else {
                System.out.println(lessThanWorth + " months");
            }
        }
    }
}
