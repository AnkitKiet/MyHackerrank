package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_luck_sum {

    public static void main(String[] ar){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> luck = new ArrayList<>();
        ArrayList<Integer> rating = new ArrayList<>();
        int arr[]=new int[n];
        int sum=0;
        for(int i=0,j=0;i<n;i++){

            luck.add(sc.nextInt());
            rating.add(sc.nextInt());
            sum+=luck.get(i);
            if(rating.get(i)==1){
                arr[j++]=luck.get(i);
            }
        }
        Arrays.sort(arr);
        int diff=0;
        for(int i=0;i<arr.length-k;i++){
            diff+=arr[i];
        }
        System.out.println(sum-(2*diff));
    }

}

