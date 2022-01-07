package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        try {
            File myObj = new File(ClassLoader.getSystemResource("input_day3.txt").getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        List<Integer[]> squares = new ArrayList<>();
        for (String input:inputs
             ) {
            System.out.println(input);
            String[] parts = input.split("\\s@\\s");
            parts = parts[1].split(":\\s");
            int x = Integer.parseInt(parts[0].split(",")[0]);
            int y = Integer.parseInt(parts[0].split(",")[1]);
            int width = Integer.parseInt(parts[1].split("x")[0]);
            int depth = Integer.parseInt(parts[1].split("x")[1]);

//            String coordinates = "("+x+","+y+"),("+(x+width)+","+(y+depth)+")";
//            System.out.println(coordinates);
            Integer[] coordinateArray = new Integer[4];
            coordinateArray[0] = x;
            coordinateArray[1] = y;
            coordinateArray[2] = x + width;
            coordinateArray[3] = y + depth;
            squares.add(coordinateArray);

        }

        //Total area
        long totalArea = 0;
        for (int i = 0; i < squares.size(); i++) {
            totalArea += volume(squares.get(i));
        }
        for (int i = 0; i < squares.size() ; i++) {
            for (int j = i + 1; j < squares.size(); j++) {
               System.out.println(""+i+","+j);
               System.out.println(volume(intersection(squares.get(i), squares.get(j))));
            }
        }
    }
    public static long volume(Integer[] square) {
        if(square == null)
            return 0;
        return (square[1] - square[0]) * (square[3] - square[2]);
    }

    public static Integer[] intersection(Integer[] s1, Integer[] s2){
        if((s1[1] < s2[0]) || (s1[3] < s2[2]))
            return null;
        Integer[] iSquare = new Integer[4];
        iSquare[0] = Math.max(s1[0], s2[0]);
        iSquare[1] = Math.min(s1[1], s2[1]);
        iSquare[2] = Math.max(s1[2], s2[2]);
        iSquare[3] = Math.min(s1[3], s2[3]);
        return iSquare;
    }
}
