import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day3b {

    public static int findTreeEncounter(int[] movement,File file) throws FileNotFoundException {
        int encounters = 0;
        int lines = 0;
        Scanner scanner = new Scanner(file);
        int position = 0;
        int skip = movement[1];
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (lines % skip == 0){
                if (line.charAt(position) == '#'){
                    encounters++;
                }
                position = (position + movement[0]) % line.length();
            }
            lines++;
            }
        scanner.close();
        return encounters;
    }

    public static void main(String[] args) throws FileNotFoundException {

        int movements[][] = {{3,1},{1,1},{5,1},{7,1},{1,2}};
        // int movements[][] = {{1,2}};
        File file = new File("input/Day3input.txt");

        long product = 1;
        for (int[] movement : movements){
            int e = findTreeEncounter(movement, file);
            product = product * e;
            System.out.printf("function: %d\tproduct: %d\n",e,product);
        }
        System.out.printf("%d",product);

}


}