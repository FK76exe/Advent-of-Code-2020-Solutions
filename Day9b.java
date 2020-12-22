import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day9b {

    public static long ArrSum(List<Long> allnums){
        long sum = 0; //0 = sum, 1 = min, 2 = max

        for (int i = 0; i < allnums.size(); i++){
            sum = sum + allnums.get(i);
        }

        return sum;
    }

    public static long SumMinMax(List<Long> allnums){
        long[] MinMax = {allnums.get(0),allnums.get(0)}; //0 = min; 1 = max
        for (int i = 1; i < allnums.size(); i++){
            if (allnums.get(i) < MinMax[0]){
                MinMax[0] = allnums.get(i);
            }
            else if (allnums.get(i) > MinMax[1]){
                MinMax[1] = allnums.get(i);
            }
        }
        return MinMax[0] + MinMax[1];

    }

    public static void main(String[] args) throws FileNotFoundException {
      
        
        File file = new File("input/Day9.txt");
        Scanner scanner = new Scanner(file);

        long[] nums = new long[25];
        int x = 0;
        boolean notprev25 = false;
        List<Long> allnums = new ArrayList<Long>();
        long broker = -1;

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
                    broker = num;
                    notprev25 = true;
                    // System.out.println(num);
                    break;
                }
            }
            if (!scanner.hasNextLong()){
                break;
            }
            nums[x%25] = num;
            x++;
            allnums.add(num);
        }

        scanner.close();

        //check for contious sum and min/max values in them

        for (int i = 0; i < allnums.size(); i++){
            for (int j = i; j < allnums.size(); j++){
                List<Long> slice = allnums.subList(i, j);
                if (ArrSum(slice) == broker){
                    long W = SumMinMax(slice);
                    System.out.println(W);
                }
            }
        }
    }


    }

