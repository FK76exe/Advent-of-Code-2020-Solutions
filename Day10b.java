import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10b {
    
    // static HashMap<Integer,Long> hash = new HashMap<Integer,Long>();
    static Map<Long,Long> memo = new HashMap<Long,Long>();

    public static long validPaths(List<Long> nums, long x){
        if (x == nums.get(0)){
            // System.out.printf("%d\n",x);
            return 1;
        }
        else if(memo.containsKey(x)){
            return memo.get(x);
        }
        else{
            long valid = 0;
            // long key = -1;
                for (int i = 1; i < 4; i++){
                    if (nums.contains(x-i)){
                        // System.out.printf("%d -> ",x,x+i);
                        valid = valid + validPaths(nums, x-i);
                        // key = x-i;
                    }
                }
                // System.out.printf("valid paths from %d: %d\n",x,valid);
            memo.put(x,valid);
            return valid;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input/Day10.txt");
        Scanner scanner = new Scanner(file);
        List<Long> nums = new ArrayList<Long>();

        /* Plan
        put all jolts in a list, find max (add 3 to it), navigate sorted list with jumps of 1 or 3
        */
        while (true){
            if (!scanner.hasNextLong()){
                break;
            }
            nums.add(scanner.nextLong());
        }
        scanner.close();
        
        Collections.sort(nums);
        nums.add(0,(long) 0);
        nums.add(nums.get(nums.size()-1)+3);

        System.out.println(validPaths(nums, nums.get(nums.size()-1)));
        // System.out.println(memo);


    }

}
