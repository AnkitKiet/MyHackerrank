package edu;

import java.util.*;

public class MissingNumbers {

    public static void main(String[] ar) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            if (!map.containsKey(num))
                map.put(num, -1);
            else {
                int count = map.get(num);
                map.put(num, --count);
            }
        }
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int get_count = map.get(num);
            map.put(num, ++get_count);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0)
                System.out.println(entry.getKey() + " ");
        }






//Second method failed one testcase due to timeout

        /*for (int number:list_1) {
            if(list_2.contains(number)){
                int occurrences1 = Collections.frequency(list_1, number);
                int occurrences2 = Collections.frequency(list_2, number);
                if(occurrences1!=occurrences2){
                    if(!list_3.contains(number))
                        list_3.add(number);
                }
            }else{
                if(!list_3.contains(number))
                list_3.add(number);
            }
        }
            Collections.sort(list_3);
        for (int num:list_3) {
            System.out.print(num+" ");
        }*/
    }

}
