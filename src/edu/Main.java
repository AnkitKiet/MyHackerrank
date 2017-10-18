package edu;

import java.util.Arrays;
import java.util.OptionalLong;
import java.util.Scanner;

public class Main {



    static long stockPurchaseDay(long[] A, long xi) {
        // Complete this function

        long min = Arrays.stream(A).min().getAsLong();

        int index = -1;
        if(xi<min){
            return -1;
        }else{

            for(int i=A.length-1;i>=0;i--){

                if(xi>=A[i]){

                    index= i+1;
                    return index;


                }

            }
            return index;

        }



    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextLong();
        }
        System.out.println("enter q");
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long xi = in.nextLong();
            long result = stockPurchaseDay(A, xi);
            System.out.println(result);
        }
        in.close();
    }
}
