package edu;

import java.util.ArrayList;
import java.util.Scanner;

public class stackOverflow {

    public static void main(String ar[]) {
/*********************Rough Data For Trial***********************/
        int arr[][][] = new int[3][3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    (arr[i][j][k]) = (int) Math.random();
                }
            }
        }
        arr[1][2][1] = 5;
        arr[2][2][1] = 5;
        arr[2][2][2] = 5;
        int value = 5;
        Scanner scanner=new Scanner(System.in);
        int row = 5;
        int col = 5;
        ArrayList<Integer> list=null;
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
                list = new ArrayList<>();
                list.add(scanner.nextInt());
            }
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            lists.add(list);
        }
        /***************Use below code now as your function****************/
        find_indices(arr, value);

    }

    private static void find_indices(int[][][] arr, int value) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i][j][k] == value) {
                        list.add(String.valueOf(i));
                        list.add(String.valueOf(j));
                        list.add(String.valueOf(k));
                        list.add(String.valueOf("\n"));
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

}
