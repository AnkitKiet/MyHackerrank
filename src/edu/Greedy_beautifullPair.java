package edu;

import java.util.Scanner;

public class Greedy_beautifullPair {

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[1001];
        int sum = 0;
        for(int i=1;i<=n;i++)
            a[sc.nextInt()]++;


        for(int i=1;i<=n;i++)
        {
            int v = sc.nextInt();
            if(a[v]>0)
            {
                sum++;
                a[v]--;
            }
        }



        if(sum<n)
            System.out.print(sum+1);
        else
            System.out.print(sum-1);

    }


}
