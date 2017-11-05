package edu;

import java.util.Scanner;

public class BeautifullTriplets {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int num,inner_count,count=0;
        for (int i = 0; i <= n - 3; i++) {
            num = arr[i];
            inner_count=0;
            for (int j = i+1; j < n; j++) {
                if (arr[j]-num == d) {
                    num = arr[j];
                    inner_count++;
                }
                if(inner_count==2){
                    count++;
                    break;

                }
            }
        }
        System.out.println(count);

    }
}
