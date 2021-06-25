package topK;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < ropeLengths.length; i++) {
            minheap.add(ropeLengths[i]);
        }
        int cost = 0;
        while (minheap.size() > 1) {
            int intermittent = minheap.poll() + minheap.poll();
            //if(minheap.size()!=0)
                minheap.add(intermittent);
            cost+=intermittent;
        }
        return cost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{3, 4, 5, 6});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5, 2});
        System.out.println("Minimum cost to connect ropes: " + result);
    }

}