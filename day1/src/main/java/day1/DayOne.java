package day1;

import java.io.File;
import java.util.*;

public class DayOne {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File(ClassLoader.getSystemResource("input_day1.txt").getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        long frequency = 0;

        for (String input:inputs
             ) {
            frequency += Long.parseLong(input);
        }
        System.out.println("Answer part 1: " + frequency);

        frequency = 0;
        boolean repeat = false;
        Set<Long> visitedFrequencies = new HashSet<>();
        while(!repeat){
            for (String input:inputs
            ) {
                frequency += Long.parseLong(input);
                if(visitedFrequencies.contains(frequency)) {
                    repeat = true;
                    break;
                }
                visitedFrequencies.add(frequency);
            }
        }

        System.out.println("Answer part 2: " + frequency);
    }

}
