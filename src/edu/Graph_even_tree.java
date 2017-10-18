package edu;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph_even_tree {

    static class Node {
        int num, root;
        Node set(int num,int root){
           Node node=new Node();
            node.num=num;
            node.root=root;
            return node;
        }
    }

    public static void main(String[] args) {

        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            list.add(node.set(1,-1));
        }
        for (int i = 0; i < m; i++) {

            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            list.get(x - 1).root = y - 1;
        }

        for (int i = n - 1; i > 0; i--)
            if (list.get(i).root >= 0)
                list.get(list.get(i).root).num += list.get(i).num;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (list.get(i).root >= 0 && list.get(i).num % 2 == 0)
                count++;
        System.out.println(count);
    }
}