package com.company;
import java.util.Arrays;
public class BruteCollinearPoints {
    private int k=0;
    private BruteCollinearPoints a;
    private LineSegment[] segments = new LineSegment[2];
    private void addTo(LineSegment[] segments, LineSegment a){
        segments[k] = a;
        k++;
        if(k>=(segments.length/2)){
            LineSegment[] A = new LineSegment[k];
            for(int i=0; i<k; i++){
                A[i] = segments[i];
            }
            segments = new LineSegment[segments.length*2];
            for(int i=0; i<k; i++){
                segments [i] = A [i];
            }
        }
    }

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
        Arrays.sort(points);
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
                             LineSegment b = new LineSegment(points [i],points [h]);
                             a.addTo(segments,b);
                         }
                    }
                }
            }
        }
    }    // finds all line segments containing 4 points

    public           int numberOfSegments(){return k;}        // the number of line segments

    public LineSegment[] segments(){return segments;}                // the line segments
}
