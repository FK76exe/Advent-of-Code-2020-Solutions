import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day4.txt");
        Scanner scanner = new Scanner(file);

        //fields needed (cid to be ignored)
        String[] requiredFields = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
        int validPassports = 0; //passport needs these 7 fields to be considered valid
        int fields = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!line.isBlank()){
                // System.out.println(line);
                for (String category : requiredFields){
                    if (line.contains(category)){
                        fields++;
                    }
                }
            }
            else{
                if(fields == 7){
                    validPassports++;
                }
                fields=0;
            }
        }
        //check last field
        if (fields == 7){validPassports++;}
        
        scanner.close();
        System.out.printf("valid passports: %d",validPassports);

    }
}
