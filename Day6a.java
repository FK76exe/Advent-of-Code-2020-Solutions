import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class Day6a{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day6.txt");
        Scanner scanner = new Scanner(file);
        int sumCounts = 0;
        List<Character> alphabet = new ArrayList<Character>();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!line.isBlank()){
                CharacterIterator iter = new StringCharacterIterator(line);
                while(iter.current() != CharacterIterator.DONE){
                    if (!alphabet.contains(iter.current())){
                        alphabet.add(iter.current());
                    }
                    iter.next();
                }
            }
            else{
                sumCounts = sumCounts + alphabet.size();
                alphabet.clear();
            }
            if (!scanner.hasNextLine()){
                sumCounts = sumCounts + alphabet.size();
                alphabet.clear();              
            }
        }

        System.out.println(sumCounts);
        scanner.close();
    }
}