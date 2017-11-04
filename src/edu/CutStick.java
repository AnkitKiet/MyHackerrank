package edu;

import java.util.*;

public class CutStick {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i =0; i < n ; i++){
            list.add(sc.nextInt());
        }
        while(list.size()!=0){
            System.out.println(list.size());
            Collections.sort(list);
            list.removeAll(Collections.singleton(list.get(0)));
        }
    }

}
