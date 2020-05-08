import java.util.Arrays;
import java.util.Scanner;
import java.util.Collection;

class Main {
    static class Contestant implements Comparable<Contestant>{
        int id = 0;
        int probs = 0;
        int time = 0;
        int sub = 0;

        Contestant(int i, int p, int t){
            this.id = i;
            this.probs = p;
            this.time = t;
        }
        Contestant(int i, int t){
            this.id = i;
            this.time = t;
        }

        public void setId(int id){
            this.id = id;
        }
        public void setProbs(int p){
            this.probs = p;
        }

        public void setSub(int s){
            this.sub = s;
        }

        public void incrementProbs(){
            this.probs++;
        }

        public void addTime(int t){
            this.time += t;
        }

        public int getId(){
            return this.id;
        }

        public int getProbs(){
            return this.probs;
        }

        public int getTime(){
            return this.time;
        }

        public int getSub(){
            return this.sub;
        }

        public void printValues(){
            System.out.println(id + " " + probs + " " + time);
        }

        @Override
        public int compareTo(Contestant c){
            if(this.probs > c.probs){
                return -1;
            }else if(this.probs < c.probs){
                return 1;
            }else if(this.time < c.time){
                return -1;
            }else if(this.time > c.time){
                return 1;
            }else if(this.id < c.id){
                return -1;
            }else{
                return 1;
            }
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.next());
        sc.nextLine();
        sc.nextLine();
        for(int i = 0; i < cases; i++) {
            Contestant[] contArr = new Contestant[100];
            for(int j = 0; j < 100; j++){
                contArr[j] = new Contestant(j+1, 0, 0);
            }
            while (true) {
                Scanner line = new Scanner(sc.nextLine());
                if (!line.hasNext()) {
                    break;
                }
                int contestant = Integer.parseInt(line.next());
                int problem = Integer.parseInt(line.next());
                int time = Integer.parseInt(line.next());
                String judge = line.next();

                contArr[contestant-1].setSub(1);

                if(judge.compareTo("I") == 0){
                    contArr[contestant-1].addTime(20);
                }
                if(judge.compareTo("C") == 0){
                    contArr[contestant-1].addTime(time);
                    contArr[contestant-1].incrementProbs();
                }
            }
            Arrays.sort(contArr);
            for(int j = 0; j < 100; j++){
                if(contArr[j].getSub() != 0){
                    contArr[j].printValues();
                }
            }
        }
    }
}
