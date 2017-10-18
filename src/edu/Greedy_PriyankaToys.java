package edu;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_PriyankaToys {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int x=arr[0];
        int y=x+4;
        int count=0;
        for(int i=0;i<n;i++){
            if(!(arr[i]>=x && arr[i]<=y)){
                x=arr[i];
                y=x+4;
                count++;
            }
        }
        System.out.println(count+1);

    }

}
