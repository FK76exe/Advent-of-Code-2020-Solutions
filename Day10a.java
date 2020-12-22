import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10a {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input/Day10.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> nums = new ArrayList<Integer>();

        /* Plan
        put all jolts in a list, find max (add 3 to it), navigate sorted list with jumps of 1 or 3
        */
        while (true){
            if (!scanner.hasNextInt()){
                break;
            }
            nums.add(scanner.nextInt());
        }
        scanner.close();
        
        Collections.sort(nums);
        nums.add(nums.get(nums.size()-1)+3);
        nums.add(0,0);
        int diff1 = 0;
        int diff3 = 0;
        for (int i = 1; i < nums.size(); i++){
            if (nums.get(i) - nums.get(i-1) == 1){
                diff1++;
            }
            else{
                diff3++;
            }
        }
        System.out.println(diff1*diff3);

    }
}
