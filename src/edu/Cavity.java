package edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Cavity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str;
        String[] splitValue;
        int arr[][] = new int[n][n];
        int arr1[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            str = sc.next();
            splitValue = str.split("");
            int j = 0;
            for (String a : splitValue) {
                arr[i][j++] = Integer.parseInt(a);
            }
        }
        arr1 = arr;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int mid = arr[i][j];
                if (arr[i - 1][j] < mid && arr[i][j - 1] < mid && arr[i][j + 1] < mid && arr[i + 1][j] < mid)
                {
                    arr1[i][j] = -1;

                }
                else{
                    arr1[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] == -1) {
                    System.out.print("X");
                } else
                    System.out.print(arr1[i][j]);
            }
            System.out.println();
        }


    }

}
