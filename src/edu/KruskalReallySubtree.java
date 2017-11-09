package edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalReallySubtree {

    static class Graph {

        int src;
        int dest;
        int weight;

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }


    public static void main(String ar[]) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Graph> list = new ArrayList<>();
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            Graph obj = new Graph();
            obj.setSrc(scanner.nextInt());
            obj.setDest(scanner.nextInt());
            obj.setWeight(scanner.nextInt());
            list.add(obj);
        }
        Collections.sort(list, (o1, o2) -> o1.getWeight() - (o2.getWeight()));
        ArrayList<Integer> list_include = new ArrayList<>();
        long sum = 0;
        for (int i=0;i<list.size();i++) {
            Graph G = list.get(i);
            if (check_exist(G, list_include)) {
                sum += G.getWeight();
                list_include.add(G.getSrc());
                list_include.add(G.getDest());
                list.remove(G);
                Collections.sort(list, (o1, o2) -> o1.getWeight() - (o2.getWeight()));

                i=-1;
            }

        }


        System.out.println(sum);
    }

    private static boolean check_exist(Graph graph, ArrayList<Integer> list) {
        boolean check = false;
        if((list.isEmpty())){
            check=true;
        }else if (list.contains(graph.getSrc()) && list.contains(graph.getDest()))
            check = false;
        else if ((list.contains(graph.getSrc()) && !list.contains(graph.getDest())))
            check = true;
        else if (list.contains(graph.getDest()) && (!list.contains(graph.getSrc())))
            check = true;
        return check;
    }



}

