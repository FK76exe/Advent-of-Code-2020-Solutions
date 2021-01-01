import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day12a {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day12.txt");
        Scanner scanner = new Scanner(file);
        //ship starts east
        int NorthSouth = 0; // North >= 0, South < 0
        int EastWest = 0; // East >= 0, West < 0
        int orientation = 0; //East = 0; North = 90; West = 180; South = 270; L > 0 & R < 0

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.contains("N")){
                NorthSouth = NorthSouth + Integer.parseInt(line.substring(1));
            }
            else if (line.contains("S")){
                NorthSouth = NorthSouth - Integer.parseInt(line.substring(1));
            }
            else if (line.contains("E")){
                EastWest = EastWest + Integer.parseInt(line.substring(1));
            }
            else if (line.contains("W")){
                EastWest = EastWest - Integer.parseInt(line.substring(1));
            }
            else if (line.contains("L")){
                int sum = orientation + Integer.parseInt(line.substring(1));
                if (sum >= 360){
                    orientation = sum % 360;
                }
                else{
                    orientation = sum;
                }
                
            }
            else if (line.contains("R")){
                int sum = orientation - Integer.parseInt(line.substring(1));
                if (sum >= 0){
                    orientation = sum;
                }
                else{
                    orientation = 360 + sum;
                }
            }
            else{
                if (orientation % 180 == 0){
                    if (orientation == 0){
                        EastWest = EastWest + Integer.parseInt(line.substring(1));
                    }
                    else{
                        EastWest = EastWest - Integer.parseInt(line.substring(1));
                    }
                }
                else if (orientation == 90){
                    NorthSouth = NorthSouth + Integer.parseInt(line.substring(1));
                }
                else{
                    NorthSouth = NorthSouth - Integer.parseInt(line.substring(1));
                }
            }
        // System.out.printf("%s Orientation: %d\n",line,orientation);
        }
        scanner.close();
        System.out.printf("E/W: %d N/S: %d\nManhattan Distance: %d\n",EastWest,NorthSouth,Math.abs(EastWest)+Math.abs(NorthSouth));
    }

}
