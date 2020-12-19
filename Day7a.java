import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7a {

    public static boolean hasShinyGold(Map<String,List<String>> bags, String color){
        if (bags.get(color).size() == 0){
            return false;
        }
        else if (bags.get(color).contains("shiny gold")){
            return true;
        }
        else{
            boolean inChild = false;
            for (String childColor: bags.get(color)){
                if (hasShinyGold(bags, childColor)){
                    inChild = true;
                    break;
                }
            }
            return inChild;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("input/Day7.txt");
        Scanner scanner = new Scanner(file);
        Map<String,List<String>> bags = new HashMap<>();

        //scrape to map + find valid bags to count
        boolean finished = false;
        while (!finished){
            String line = scanner.nextLine();
            String bag = line.split(" bags contain ")[0];
            String contents = line.split(" bags contain ")[1];
            bags.put(bag,new ArrayList<String>());
            Pattern pattern = Pattern.compile("[0-9]\\s([\\w]+\\s[\\w]+)");
            Matcher matcher = pattern.matcher(contents);
            while (matcher.find()){
                bags.get(bag).add(matcher.group(1));
            }

            if (!scanner.hasNextLine()){
                finished = true;
            }   
        }
        scanner.close();

        int bagswithSG = 0; // 1 bc of shiny gold bag itself
        for (String color : bags.keySet()){
            if (!color.equals("shiny gold")){
                if (hasShinyGold(bags,color)){
                    bagswithSG++;
                }
            }
            else{
                System.out.println("no worries");
            }
        }

        System.out.println(bagswithSG);

    }


}
