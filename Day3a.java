import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day3a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day3input.txt");
        Scanner scanner = new Scanner(file);
        int position = 0;
        int trees = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.charAt(position % line.length()) == '#'){
                trees++;}
            position = position + 3;
            }
        scanner.close();
        System.out.printf("Trees encountered: %d",trees);
    }
}    

