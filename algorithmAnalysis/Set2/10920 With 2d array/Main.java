import java.util.Scanner;

class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(true){
            int size = Integer.parseInt(sc.next());
            int[][] tap = new int[size][size];
            int position = Integer.parseInt(sc.next());
            if(size == 0 && position == 0){
                System.exit(0);
            }

            int area = size*size;
            int tempSize;
            int x = size-1;
            int y = size-1;
            int i = area;
            while(i>0) {
                area = i;
                tempSize = (int)Math.sqrt(i);
                while (i > 0 && i > area - tempSize) {
                    tap[x][y] = i;
                    x--;
                    i--;
                }
                x++;
                y--;
                while (i > 0 && i > area - (tempSize + tempSize - 1)) {
                    tap[x][y] = i;
                    y--;
                    i--;
                }
                y++;
                x++;
                while (i > 0 && i > area - (tempSize + tempSize + tempSize - 2)) {
                    tap[x][y] = i;
                    x++;
                    i--;
                }
                x--;
                y++;
                while (i > 0 && i > area - (tempSize + tempSize + tempSize + tempSize - 4)) {
                    tap[x][y] = i;
                    y++;
                    i--;
                }
                y--;
                x--;
            }
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(tap[j][k]== position){
                        System.out.println("Line = " + (j+1) + ", column = " + (k+1) + ".");
                    }
                }
            }
        }
    }
}

