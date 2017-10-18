package edu;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_min_diff {


    static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        ArrayList<Pair<Integer,Integer>>list=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            Pair<Integer,Integer> pair=new Pair(arr[i],arr[i+1]);
            list.add(pair);
        }
        int less=Integer.MAX_VALUE;
        for(Pair<Integer,Integer> pair:list) {
            int min = Math.abs(pair.getKey()-pair.getValue());
            if(min<less){
                less=min;
            }

        }
        return less;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }

}
