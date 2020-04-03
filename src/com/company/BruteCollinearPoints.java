package com.company;

public class BruteCollinearPoints {
    private int k=0;
    private LineSegments[2] segments;
    public BruteCollinearPoints(Point[] points){
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
        points.sort();
        for (int i=0; i<m; i++)
        {
            for(int j=i+1; j<m; m++)
            {
                for(int l=j+1;l<m;l++)
                {
                    for(int h=l+1; h<m; h++)
                    {
                         if(points[h].slopeTo(points[l])==points[l].slopeTo(points[j]) && points[l].slopeTo(points[j])==points[j].slopeTo(points[i]))
                         {
                             segments[k] = LineSegment(points[i],points[h]);
                             k++;
                         }
                    }
                }
            }
        }
    }    // finds all line segments containing 4 points

    public           int numberOfSegments(){return k;}        // the number of line segments

    public LineSegment[] segments()                // the line segments
}
