package com.company;
import java.util.Arrays;
import java.util.LinkedList;
public class BruteCollinearPoints {
    private int y = 0;
    private LinkedList<LineSegment> segments = new LinkedList<>();

    public BruteCollinearPoints(Point[] points) {
        int m = points.length;
        if (points == null) {
            throw new IllegalArgumentException("Null massive");
        }
        for (int p = 0; p < m; p++) {
            for (int g = p + 1; g < m; g++) {
                if (points[p].compareTo(points[g]) == 0 || points[p] == null || points[g] == null) {
                    throw new IllegalArgumentException("Wrong Argument");
                }
            }
            Arrays.sort(points);
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; m++) {
                    for (int l = j + 1; l < m; l++) {
                        for (int h = l + 1; h < m; h++) {
                            if (points[h].slopeTo(points[l]) == points[l].slopeTo(points[j]) && points[l].slopeTo(points[j]) == points[j].slopeTo(points[i])) {
                                LineSegment b = new LineSegment(points[i], points[h]);
                                segments.add(b);
                                y++;
                            }
                        }
                    }
                }
            }
        }    // finds all line segments containing 4 points
    }

    public int numberOfSegments() {
        return y;
    }      // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] Segments = segments.toArray(new LineSegment[y]);
        return Segments;
    }
}
