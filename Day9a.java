import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9a {
    
    public static void main(String[] args) throws FileNotFoundException{
        
        File file = new File("input/Day9.txt");
        Scanner scanner = new Scanner(file);

        long[] nums = new long[25];
        int x = 0;
        boolean notprev25 = false;

        while (!notprev25){
            long num = scanner.nextLong();
            if (x >= 25){
                boolean prev25sum = false;
                for (int i = 0; i < 25; i++){
                    for (int j = 0; j < 25; j++){
                        if (nums[i] + nums[j] == num && i != j){
                            prev25sum = true;
                        }
                    }
                }
                if (!prev25sum){
                    notprev25 = true;
                    System.out.println(num);
                    break;
                }
            }
            if (!scanner.hasNextLong()){
                break;
            }
            nums[x%25] = num;
            x++;
        }

        scanner.close();

    }

}
