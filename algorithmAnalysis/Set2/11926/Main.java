import java.util.Scanner;
import java.util.BitSet;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            String conflict = "NO CONFLICT";
            BitSet bs = new BitSet(1000001);
            int oneTime = Integer.parseInt(sc.next());
            int repeat = Integer.parseInt(sc.next());
            if(oneTime == 0 && repeat == 0){
                System.exit(0);
            }

            for(int i = 0; i < oneTime; i++){
                int start = Integer.parseInt(sc.next());
                int end = Integer.parseInt(sc.next());
                for(int j = start; j < end; j++){
                    if(bs.get(j)){
                        conflict = "CONFLICT";
                    }
                }
                bs.set(start, end);
            }
            for(int i = 0; i < repeat; i++){
                int start = Integer.parseInt(sc.next());
                int end = Integer.parseInt(sc.next());
                int rep = Integer.parseInt(sc.next());
                //int count = start;
                while(start < 1000000) {
                    for (int j = start; j < end; j++) {
                        if (bs.get(j)) {
                            conflict = "CONFLICT";
                        }
                    }
                    bs.set(start, end);
                    start += rep;
                    end += rep;
                }
            }
            System.out.println(conflict);
        }

    }
}
