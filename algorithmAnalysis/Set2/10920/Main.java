import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true) {
            int size = Integer.parseInt(sc.next());
            long position = Long.parseLong(sc.next());
            if(size == 0 && position == 0){
                System.exit(0);
            }
            long inner = 1;
            long prev = 1;
            while(inner < 100000){
                if((inner*inner) >= position){
                    break;
                }
                prev = inner;
                inner += 2;
            }
            long[] border = new long[(int)inner*4];
            long area = inner*inner;
            long num = area;
            int index = 0;
            long posIndex = 0;
            long row = 0;
            long column = 0;
            while(num > (prev*prev) && position != 1){
                    border[index] = num;
                    if(num == position){
                        posIndex = num;
                        break;
                    }
                    index++;
                    num--;
            }

            if(position == 1){
                row = column = (size+1)/2;
            }
            else if(posIndex > area-inner) {//right side
                column = ((size-1)/2) + ((inner-1)/2)+1;
                int rowCount = 0;
                for(long j = area-inner; j<= posIndex; j++){
                    rowCount++;
                }
                rowCount -= (inner - ((inner-1)/2));
                row = ((size-1)/2) + rowCount;
            }

            else if(posIndex < area - (inner+inner-2) && posIndex > area - (inner*3-2)){ //left
                column = ((size-1)/2)- ((inner-1)/2)+1;
                int rowCount = 1;
                for(long j = area - (inner+inner-2); j >= posIndex; j--){
                    rowCount++;
                }
                rowCount -= (inner - ((inner-1)/2));
                row = ((size-1)/2) + rowCount;
            }

            else if(posIndex > area - (inner+inner-1) && posIndex < area-(inner-1)){ //bottom
                int columnCount = 0;
                for(long j = area - (inner+inner-1); j <= posIndex; j++){
                    columnCount++;
                }
                columnCount -= (inner - ((inner-1)/2));
                column = ((size-1)/2) + columnCount;

                row = ((size-1)/2)- ((inner-1)/2)+1;
            }

            else if(posIndex < area - (inner*3-3)){//top
                int columnCount = 1;
                for(long j = area - (inner*3-3); j >= posIndex; j--){
                    columnCount++;
                }
                columnCount -= (inner - ((inner-1)/2));
                column = ((size-1)/2) + columnCount;

                row = ((size-1)/2) + ((inner-1)/2)+1;
            }
            System.out.println("Line = " + row + ", column = " + column + ".");
        }
    }
}
