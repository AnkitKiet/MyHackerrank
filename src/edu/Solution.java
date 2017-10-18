package edu;


import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=1;i<=m;i++){
            map.put(i,0);
        }


            for(int a0 = 0; a0 < n; a0++){
            int id = in.nextInt();
            int amount = in.nextInt();
            map.put(id,map.get(id)+amount);

        }

int sum=0;
        for (HashMap.Entry<Integer,Integer> entry : map.entrySet())
        {
             //   System.out.println(entry.getKey()+"  "+ entry.getValue());
                sum+=entry.getValue();

        }
        int value = (int) Math.floor(sum/m);

        if(sum%m==0){
            for (HashMap.Entry<Integer,Integer> entry : map.entrySet())
            {
                 int fin =entry.getValue()-(value);
                System.out.println(entry.getKey()+"  "+fin );
               // sum+=entry.getValue();

            }
        }else{

            for (HashMap.Entry<Integer,Integer> entry : map.entrySet())
            {
                int extra = sum-((int)Math.floor(sum/m))*m;
                int fin =entry.getValue()-(value);
                if(entry.getKey()==1){
                  //  System.out.println("e"+extra+"f"+fin);
                    int val=fin-extra;
                    System.out.println(entry.getKey()+" "+ val);
                }else
                System.out.println(entry.getKey()+" "+fin );
                // sum+=entry.getValue();

            }

        }




        in.close();
    }

}
