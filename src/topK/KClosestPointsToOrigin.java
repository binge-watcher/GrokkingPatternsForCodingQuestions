package topK;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

public class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        PriorityQueue<Point> maxheap = new PriorityQueue<>((p1,p2)-> p1.distFromOrigin()-p2.distFromOrigin());
        for(int i=0;i<points.length;i++){
            if(maxheap.size()<k)
                maxheap.add(points[i]);
            else{
                if(maxheap.peek().distFromOrigin()>points[i].distFromOrigin()){
                    maxheap.poll();
                    maxheap.add(points[i]);
                }
            }
        }
        while(maxheap.size()>0){
            result.add(maxheap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
