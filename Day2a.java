import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day2a{
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input/Day2input.txt");
        Scanner scanner = new Scanner(input);

        int matches = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String password = line.split(": ")[1];
            int min = Integer.parseInt(line.split(": ")[0].split("-")[0]);
            int max = Integer.parseInt(line.split(": ")[0].split("-")[1].split(" ")[0]);
            char c = line.split(": ")[0].charAt(line.split(": ")[0].length()-1);
            
            int c_count = 0;
            for (int i = 0; i < password.length(); i++){
                if (password.charAt(i) == c){
                    c_count += 1;
                }
            }
            if (c_count >= min && c_count <= max){
                matches += 1;
            }
        }
        scanner.close();
        System.out.printf("%d\n",matches);
    }
}