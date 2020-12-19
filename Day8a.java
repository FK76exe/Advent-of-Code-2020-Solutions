import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day8a {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input/Day8.txt");
        Scanner scanner = new Scanner(file);
        List<String> instructionCode = new ArrayList<String>();
        List<Integer> instructionVal = new ArrayList<Integer>();

        boolean finished = false;
        while (!finished){
            String line = scanner.nextLine();
            instructionCode.add(line.split(" ")[0]);
            instructionVal.add(Integer.parseInt(line.split(" ")[1]));
            if (!scanner.hasNextLine()){
                finished = true;
            }
        }
        scanner.close();

        List<Integer> visited = new ArrayList<Integer>();

        int acc = 0;
        int i = 0;
        while (visited.size() <= instructionCode.size()){
            if (!instructionCode.get(i).equals("jmp")){
                if (instructionCode.get(i).equals("acc")){
                    acc = acc + instructionVal.get(i);
                }
                i++;
                visited.add(i);
            }
            else{
                if (visited.contains(i + instructionVal.get(i))){
                    // System.out.println("broke");
                    break;
                }
                else{
                    i = i + instructionVal.get(i);
                    visited.add(i);
                }
            }
        }

        System.out.println(acc);

    }

}
