package com.company;
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {
    private int y=0;
    private LinkedList<LineSegment> segments = new LinkedList<>();
    public FastCollinearPoints(Point[] points)
    {
        int m = points.length;
        if(points == null){throw new IllegalArgumentException("Null massive");}
        for (int p=0; p<m; p++)
        {
            for(int g=p+1; g<m; g++)
            {
                if(points[p].compareTo(points[g])==0  || points[p]==null || points[g]==null)
                {
                    throw new IllegalArgumentException("Wrong Argument");
                }
            }
        }
        for (int i=0; i<m; i++)
        {
            Point[] pon = new Point[m-i];
            for (int k=0;k<m-i;k++)
            {
                pon[k] = points[k+i];
            }
            Arrays.sort(pon,points[i].slopeOrder());
            int j=0;
            while(j<m-i-2)
            {
                if(points[i].slopeTo(pon[j])==points[i].slopeTo(pon[j+1]) && points[i].slopeTo(pon[j]) == points[i].slopeTo(pon[j+2])) {
                    LinkedList<Point> list = new LinkedList<Point>();
                    list.add(points[i]);
                    int k=j+2;
                    int g=3;
                    while(k<(m-i-1) && points[i].slopeTo(pon[k])==points[i].slopeTo(pon[k+1])){k++; g++;}
                    while(k>=j)
                    {
                        list.add(pon[k]);
                        k--;
                    }
                    Point[] List = list.toArray(new Point[g+1]);
                    Arrays.sort(List);
                    LineSegment a = new LineSegment(List[0],List[g]);
                    segments.add(a);
                    y++;
                    j=g+j;
                }
                else
                j++;
            }
        }
    }
    // finds all line segments containing 4 or more points
    public int numberOfSegments(){return y;}        // the number of line segments

    public LineSegment[] segments()
    {
        LineSegment[] Segments = segments.toArray(new LineSegment[y]);
        return Segments;
    }
    // the line segments
}
