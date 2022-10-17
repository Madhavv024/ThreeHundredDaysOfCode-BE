package partition_equal_subset_sum.Java;

import java.io.*;
import java.util.*;

public class Driver {
    private static List<String> method(String filePath) {
        ArrayList<String> al = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {
                str = str.replace("\"","")
                        .replace("[","")
                        .replace(","," ")
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
        String filePath = "proddata/data/partition_equal_subset_sum/testcases.txt";
        List<String> al = method(filePath);
        boolean out;
        int input1[] = new int[0];
        boolean b = true;
        for (int i = 0;i< al.size();i++)
        {
            if(i % 2==0)
            {
                input1 = Arrays.stream(al.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            else
            {
                out = al.get(i).equals("true") ? true : false;
                boolean user_out = user(input1);
                b = b & out == user_out ? true : false;

                if (b == false) {
                    System.out.println("Test case");
                    System.out.println("arr = " + Arrays.toString(input1));
                    System.out.println("Your output " + user_out);
                    System.out.println("Expected output " + out);
                    return b;
                }
            }
        }
        return b;
    }

    public static boolean user(int[] arr) {
        return new partition_equal_subset_sum.Java.Solution().canPartition(arr);
    }
}