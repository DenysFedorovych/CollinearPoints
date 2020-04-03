package com.company;

public class BruteCollinearPoints {
    private int k=0;
    private void addTo(LineSegments[] segments, LineSegment a){
        segments[k] = a;
        k++;
        if(k>=(segments.length/2)){
            LineSegments[] A = new LineSegments[k];
            for(int i=0; i<k; i++){
                A[i] = segments[i];
            }
            segments = new LineSegments[segments.length*2];
            for(int i=0; i<k; i++){
                segments [i] = A [i];
            }
        }
    }
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
                             BruteCollinearPoints.addTo(segments,LineSegment(points [i],points [h]));
                         }
                    }
                }
            }
        }
    }    // finds all line segments containing 4 points

    public           int numberOfSegments(){return k;}        // the number of line segments

    public LineSegment[] segments(){return segments;}                // the line segments
}
