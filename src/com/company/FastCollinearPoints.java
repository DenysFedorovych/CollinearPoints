package com.company;

public class FastCollinearPoints {
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
            for(int j=i+1; j<m; j++)
            {

            }
        }
    }
    // finds all line segments containing 4 or more points
    public int numberOfSegments()        // the number of line segments
    public LineSegment[] segments()                // the line segments
}
