import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day11a {

    public static void main(String[] args) throws FileNotFoundException {
        
        // Phase 1: Collect input data
        File file = new File("input/Day11.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        // String[][] seatChart = new String[line.length()][line.split("").length];
        String[][] seatChart = new String[93][line.split("").length];
        scanner.reset();     
        seatChart[0] = line.split("");
        for (int i = 1; i < seatChart.length; i++){
            seatChart[i] = scanner.nextLine().split("");
        }
        scanner.close();
        
        // Step 2 and 3 done until change not found

       
        while (true){
            boolean changed = false;
            List<int[]> swapLoc = new ArrayList<int[]>();
            // Phase 2: Assess Data
            for (int i = 0; i < seatChart.length; i++){
                for (int j = 0; j < seatChart[i].length; j++){
                    String seat = seatChart[i][j];
                    if (!seat.equals(".")){
                        int OccAdj = 0;
                        for (int k = -1; k < 2; k++){
                            for (int l = -1; l < 2; l++){
                                if ( i+k < seatChart.length && i+k > -1 && j+l > -1 && j+l < seatChart[i+k].length && seatChart[i+k][j+l].equals("#") && !(i+k == i && j+l == j)){
                                    OccAdj++;
                                }
                            }
                        }
                        if (seat.equals("L") && OccAdj == 0){
                            int[] toSend = {i,j};
                            swapLoc.add(toSend);
                            changed = true;
                        }
                        else if(seat.equals("#") && OccAdj >= 4){
                            int[] toSend = {i,j};
                            swapLoc.add(toSend);
                            changed = true;
                        }
                    }
                }
            }
            
            if (changed){
                // Phase 3: Change data
                for (int[] coordinate : swapLoc){
                    if (seatChart[coordinate[0]][coordinate[1]].equals("#")){
                        seatChart[coordinate[0]][coordinate[1]] = "L";
                    }
                    else{
                        seatChart[coordinate[0]][coordinate[1]] = "#";
                    }
                }
            }
            else{
                // // Phase 4: Print data
                // for (int i = 0; i < seatChart.length; i++){
                //     System.out.println(Arrays.toString(seatChart[i]));
                // }
                break;
            }

        }
        
        // Phase 5: Check how many empty seats there are
        int emptySeats = 0;
        for (String[] row : seatChart){
            for (String seat : row){
                if (seat.equals("#")){
                    emptySeats++;
                }
            }
        }
        System.out.println(emptySeats);


    }

}
