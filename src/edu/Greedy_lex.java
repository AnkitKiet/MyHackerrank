package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_lex {

    public static void main(String[] ar){


        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        String[] line = new String [l];
        String linestr="";
        String[][] lis=new String[l][l];
        for(int i=0;i<n;i++){
            for(int j=0;j<l;j++){
                linestr=sc.next();
                line=linestr.split("");
                Arrays.sort(line);
                    lis[j]=line;


            }
            int flag=0;
            for(int j=0;j<l;j++){
                for(int k=0;k<l-1;k++) {
                    if(lis[k][j].compareTo(lis[k+1][j])>0){
                        flag=1;
                    }

                }

            }
            if (flag == 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }




    }

}
