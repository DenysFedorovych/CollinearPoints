package com.company;

public class Main {

    public static void main(String[] args) {
        Point[] points = new Point[10];
        Point a = new Point(1,0);
        Point s = new Point(6,0);
        Point d = new Point(7,0);
        Point f = new Point(9,0);
        Point g = new Point(5,3);
        Point h = new Point(14,1);
        Point j = new Point(11,1);
        Point k = new Point(10,5);
        Point z = new Point(2,1);
        Point l = new Point(0,1);
        points[0] = a;
        points[1] = s;
        points[2] = d;
        points[3] = f;
        points[4] = g;
        points[5] = h;
        points[6] = j;
        points[7] = k;
        points[8] = l;
        points[9] = z;
        BruteCollinearPoints W = new BruteCollinearPoints(points);
        System.out.println(W.numberOfSegments());
        LineSegment[] A = W.segments();
        System.out.println(A[0]);
        System.out.println(A[1]);


}
}
