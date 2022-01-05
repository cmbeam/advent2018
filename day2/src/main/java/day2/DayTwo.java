package day2;

import java.io.File;
import java.util.*;

public class DayTwo {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File(ClassLoader.getSystemResource("input_day2.txt").getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        long twoCount = 0;
        long threeCount = 0;
        for (String input:inputs
             ) {
            char[] inputArray = input.toCharArray();
            Arrays.sort(inputArray);
            System.out.println(new String(inputArray));
            boolean two = false, three = false;
            for (char letter:letters
                 ) {

                if(input.matches(".*"+letter+".*"+letter+".*"+letter+".*"+letter+".*")){

                }
                else if(input.matches(".*"+letter+".*"+letter+".*"+letter+".*"))
                {
                    System.out.println("Three match: "+letter);
                    three = true;
                }
                else if(input.matches(".*"+letter+".*"+letter+".*"))
                {
                    System.out.println("Two match: "+letter);
                    two = true;
                }
            }
            if(two) {
                twoCount++;
                System.out.println("two " + twoCount);
            }
            if(three) {
                threeCount++;
                System.out.println("three " + threeCount);
            }
        }
        System.out.println("Answer part 1: "+(twoCount * threeCount));
    }
}
