import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Day1{
public static void main(String[] args) throws FileNotFoundException {
    // System.out.println("Hello World");
    File file = new File("input/Day1input.txt");
    Scanner scanner = new Scanner(file);
    //for challenge 1
    // while(scanner.hasNextInt()){
    //     int first = scanner.nextInt();
    //     boolean found = false;
    //     Scanner scanner2 = new Scanner(file);
    //     while (scanner2.hasNextInt()){
    //         int second = scanner2.nextInt();
    //         if (first + second == 2020){
    //             System.out.printf("%d + %d = 2020\n", first,second);
    //             System.out.println(first*second);
    //             found = true;
    //             scanner2.close();
    //             break;
    //         }
    //     }
    //     if (found) {break;}
    // } 

    //for challenge 2
    boolean found = false;
    List<Integer> list = new ArrayList<>();
    while (scanner.hasNextInt()){
        list.add(scanner.nextInt());
    }
    for (int i = 0; i < list.size(); i++){
        int num1 = list.get(i);
        for (int j = i+1; j < list.size(); j++){
            int num2 = list.get(j);
            for (int k = j+1; k<list.size(); k++){
                int num3 = list.get(k);
                if (num1+num2+num3 == 2020){
                    System.out.printf("%d + %d + %d = 2020\nProduct = %d", num1,num2,num3,num1*num2*num3);
                    found = true;
                    break;
                }
            }
            if (found) {break;}
        }
        if (found) {break;}
    }


    scanner.close();
}
}