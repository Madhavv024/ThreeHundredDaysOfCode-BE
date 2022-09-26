package roman_to_integer.Java;

import java.io.*;
import java.util.*;

public class Driver {
    private static List<String> method(String filePath) {
        ArrayList<String> al = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {
                str.trim();
                str = str.replace("\"","")
                        .replace(",","")
                        .replace("[","")
                        .replace("]","");
                al.add(str);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(drivercode() ? "Accepted" : "Wrong Answer");
    }

    static boolean drivercode() {
        String filePath = "proddata/data/roman_to_integer/testcases.txt";
        List<String> al = method(filePath);
        int out;
        String input = null;
        boolean b = true;
        for (int i = 0; i < al.size(); i++) {
            if (i % 2 == 0) {
                input = al.get(i);
            } else {
                out = Integer.parseInt(al.get(i));
                int user_out = user(input);
                b = b & out == user_out ? true : false;
                if (b == false) {
                    System.out.println("Test case");
                    System.out.println("s = " + input);
                    System.out.println("Your output " + user_out);
                    System.out.println("Expected output " + out);
                    return b;
                }
            }
        }
        return b;
    }

    public static int user(String s) {
        return new roman_to_integer.Java.Solution().romanToInt(s);
    }
}
