package heap;

import java.util.PriorityQueue;

public class MedianOfAStream {

    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    MedianOfAStream(){
        maxheap = new PriorityQueue<>((a,b)->b-a);
        minheap = new PriorityQueue<>((a,b)-> a-b);
    }
    public void insertNum(int num) {
        if(maxheap.isEmpty() || num < maxheap.peek()){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }

        //rebalance
        // maxheap + 1 < minheap
        if(maxheap.size() > minheap.size()+1){
            minheap.add(maxheap.remove());
        }else if( maxheap.size()< minheap.size()){
            maxheap.add(minheap.remove());
        }
    }

    public double findMedian() {
        if(maxheap.size()==minheap.size())
            return (maxheap.peek() + minheap.peek())/2;
        else {
            return maxheap.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
