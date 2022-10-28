package first_bad_version.Java;

import java.io.*;
import java.util.*;

public class Driver {
    private static List<String> method(String filePath) {
        ArrayList<String> al = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {
                str = str.replace("\"","");
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
        String filePath = "proddata/data/first_bad_version/testcases.txt";
        List<String> al = method(filePath);
        int testcases = Integer.parseInt(al.remove(0));
        int out;
        int input1=0;
        int input2 = 0;
        boolean b = true;
        for (int i = 0;i < al.size();i++)
        {
            if(i % 2==0)
            {
                StringTokenizer st = new StringTokenizer(al.get(i));
                input1 = Integer.parseInt(st.nextToken());
                input2 = Integer.parseInt(st.nextToken());
            }
            else
            {
                out = Integer.parseInt(al.get(i));
                int user_out = user(input1);
                b = b & out == user_out ? true : false;

                if (b == false) {
                    System.out.println("Test case");
                    System.out.println("n = " + input1);
                    System.out.println("k = " + input2);
                    System.out.println("Your output " + user_out);
                    System.out.println("Expected output " + out);
                    return b;
                }
            }
        }
        return b;
    }

    public static int user(int n) {
        return new first_bad_version.Java.Solution().firstBadVersion(n);
    }
}