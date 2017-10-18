package edu;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumDistance {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0; i < n; i++){
            int diff=0;
            int elem = in.nextInt();
            if(list.contains(elem)){
                int index = list.indexOf(elem);
                diff = Math.abs(i-index);
               // System.out.println("d"+diff);

                if(diff<min){
                    min=diff;
                }else{
                    min=min;
                }
            }
            list.add(elem);

        }
        if(min==Integer.MAX_VALUE){
            min=-1;
        }
        System.out.println(min);
    }

}
