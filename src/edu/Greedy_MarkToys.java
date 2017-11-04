package edu;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_MarkToys {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k=scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int sum=0;int count=0;
        for(int i=0;i<n && sum+arr[i]<=k;i++){
            sum+=arr[i];
            count++;
        }

    }

}
