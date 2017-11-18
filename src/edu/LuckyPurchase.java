package edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LuckyPurchase {

    public static void main(String arg[]) {

        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> finallist = new ArrayList<>();
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String name = in.next();
            int value = in.nextInt();
            map.put(value, name);
            list.add(value);
        }
        for (int value : list) {
            int countF = 0;
            int countS = 0;
            boolean error = false;
            String val = String.valueOf(value);
            for (char c : val.toCharArray()) {
                int ch = Character.getNumericValue(c);
                if (ch == 4 && val.startsWith("4")) {
                    countF++;
                } else if (ch == 7 && val.startsWith("7")) {
                    countS++;
                } else {
                    error = true;
                }
                if (val.startsWith("7") && !error) {
                    countF = val.length() - countS;
                }
                if (val.startsWith("4") && !error) {
                    countS = val.length() - countF;
                }

                if (!error && countF == countS) {
                    finallist.add(value);
                }

            }

            if (finallist.size() == 0) {
                System.out.println("-1");

            } else {
                Collections.sort(finallist);
                System.out.println(map.get(finallist.get(0)));
            }



         /*   HashMap<Integer, Integer> mapC = new HashMap<>();
            mapC.put(0, 0);
            mapC.put(1, 0);
            mapC.put(2, 0);
            mapC.put(3, 0);
            mapC.put(4, 0);
            mapC.put(5, 0);
            mapC.put(6, 0);
            mapC.put(7, 0);
            mapC.put(8, 0);
            mapC.put(9, 0);
            for (char c : val.toCharArray()) {
                int count = mapC.get(Character.getNumericValue(c));
                count++;
                mapC.put(Character.getNumericValue(c), count);
            }
                int valid = check(mapC);
                if(valid==1)
                    finallist.add(value);

        */
        }

        in.close();
    }


    private static int check(HashMap<Integer, Integer> mapC) {
        int countfour = 0;
        int countsev = 0;
        for (int i = 0; i < mapC.size(); i++) {
            if (mapC.get(i) > 0 && (i != 4 && i != 7)) {
                return 0;
            } else if (i == 4 && mapC.get(4) > 0) {
                countfour++;
            } else if (i == 7 && mapC.get(7) > 0) {
                countsev++;
            }
        }

        if (countfour == countsev && (countfour != 0 && countsev != 0))
            return 1;
        else
            return 0;
    }

}
