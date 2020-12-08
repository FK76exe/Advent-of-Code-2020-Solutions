import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("input/Day5.txt");
        Scanner scanner = new Scanner(file);

        int highestID = 0;
        while (scanner.hasNextLine()){
            int min = 0;
            int max = 127;
            String line = scanner.nextLine();

            for (int i = 0; i < 7; i++){
                if (line.charAt(i) == 'F'){
                    max = min  + (max-min)/2;
                }
                else{
                    min = min + ((max-min) / 2) +1;
                }
            }

            int min1 = 0;
            int max1 = 7;
            for (int i = 7; i < 10; i++){
                if (line.charAt(i) == 'L'){
                    max1 = min1 + (max1-min1) / 2;
                }
                else{
                    min1 = min1 + ((max1-min1)/2) + 1;
                }
            }
            int ID = max*8 + max1;
            if (ID > highestID){
                highestID = ID;
            }
        }

        scanner.close();
        System.out.printf("%d",highestID);
    }
}
