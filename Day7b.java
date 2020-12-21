import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7b {

    public static int findBagsHeld(Map<String,Map<String,Integer>> bags, String color){
        
        if (bags.get(color).size() == 0){
            return 1;
        }
        else{
            int numBags =  1;
            if (color == "shiny gold"){
                numBags = 0;
            }
            for (String childcolor : bags.get(color).keySet()){
                numBags = numBags + (bags.get(color).get(childcolor) * (findBagsHeld(bags, childcolor)));
            }
            return numBags;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input/Day7.txt");
        Scanner scanner = new Scanner(file);
        Map<String,Map<String,Integer>> bags = new HashMap<>();

        boolean finished = false;
        while (!finished){
            String line = scanner.nextLine();
            String bag = line.split(" bags contain ")[0];
            String contents = line.split(" bags contain ")[1];
            bags.put(bag,new HashMap<>());
            Pattern pattern = Pattern.compile("[0-9]\\s([\\w]+\\s[\\w]+)");
            Matcher matcher = pattern.matcher(contents);
            while (matcher.find()){
                bags.get(bag).put(matcher.group(1), Character.getNumericValue(matcher.group().charAt(0)));
            }

            if (!scanner.hasNextLine()){
                finished = true;
            }   
        }
        scanner.close();

        System.out.println(findBagsHeld(bags, "shiny gold"));

    }


}
