import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day2b{
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input/Day2input.txt");
        Scanner scanner = new Scanner(input);

        int matches = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String password = line.split(": ")[1];
            int first = Integer.parseInt(line.split(": ")[0].split("-")[0]);
            int second = Integer.parseInt(line.split(": ")[0].split("-")[1].split(" ")[0]);
            char c = line.split(": ")[0].charAt(line.split(": ")[0].length()-1);
            
            if (password.charAt(first-1) == c && password.charAt(second-1) != c){
                matches++;
            }
            else if (password.charAt(first-1) != c && password.charAt(second-1) == c){
                matches++;
            }


        }
        scanner.close();
        System.out.printf("%d",matches);
    }
}