package com.company;
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {
    private int y=0;
    private LinkedList<LineSegment> segments;
    public FastCollinearPoints(Point[] points)
    {
        int m = points.length;
        for (int p=0; p<m; p++)
        {
            for(int g=p+1; g<m; g++)
            {
                if(points[p]==points[g] || points[p]==null || points[g]==null)
                {
                    throw new IllegalArgumentException("Wrong Argument");
                }
            }
        }
        for (int i=0; i<m; i++)
        {
            Point[] pon = new Point[m-i-1];
            for (int k=0;k<m-i-1;k++)
            {
                pon[k] = points[i];
            }
            Arrays.sort(pon,points[i].slopeOrder());
            for(int j=0; j<m-i-3; j++)
            {
                if(pon[j]==pon[j+1] && pon[j+1]==pon[j+2])
                {
                    LinkedList<Point> list = new LinkedList<Point>();
                    list.add(points[i]);
                    int k=j+2;
                    int g=4;
                    while(pon[k]==pon[k+1] && k<(m-i-1)){k++; g++;}
                    while(k>=j)
                    {
                        list.add(pon[k]);
                        k--;
                    }
                    j+=(g-1);
                    Point[] List = list.toArray(new Point[g]);
                    Arrays.sort(List);
                    LineSegment a = new LineSegment(List[0],List[g-1]);
                    segments.add(a);
                    y++;
                }
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
