import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class Day6b{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day6.txt");
        Scanner scanner = new Scanner(file);
        int sumCounts = 0;
        List<Character> alphabet = new ArrayList<Character>();
        boolean clean = true;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            CharacterIterator iter = new StringCharacterIterator(line);
            if (alphabet.isEmpty() && clean){
                while(iter.current() != CharacterIterator.DONE){
                alphabet.add(iter.current());
                iter.next();
                }
                clean = false;
            }
            else if (!line.isBlank()){
                    // if (!alphabet.contains(iter.current())){
                    //     alphabet.add(iter.current());
                    // }
                    // for (int i = 0; i < alphabet.size(); i++){
                    //     if (line.indexOf(alphabet.get(i)) == -1){
                    //         alphabet.remove(i);
                    //     }
                    // }
                    Iterator<Character> lstiter = alphabet.iterator();
                    while(lstiter.hasNext()){
                        if (!line.contains(Character.toString(lstiter.next()))){
                            lstiter.remove();
                        }
                    }
            }
            else{
                sumCounts = sumCounts + alphabet.size();
                alphabet.clear();
                clean = true;
            }
            if (!scanner.hasNextLine()){
                sumCounts = sumCounts + alphabet.size();
                alphabet.clear();
                clean = true;              
            }
        }

        System.out.println(sumCounts);
        scanner.close();
    }
}