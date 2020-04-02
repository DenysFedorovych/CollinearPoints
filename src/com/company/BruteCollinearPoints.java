package com.company;

public class BruteCollinearPoints {
    public BruteCollinearPoints (Point [] points)  {
        for (int j = 0; j < points.length - 4; j++) {
            double sum = 0;
            for (int i = j; i < j + 4; i++) {
                double p = points[i].slopeTo(points[i + 1]);
                sum += p;
            }
            if (sum/4 == points[j].slopeTo(points[j + 1])){
                
            }
        }
    }   // находит все сегменты линии, содержащие 4 точки
    public int numberOfSegments ()         // количество сегментов линии
    public LineSegment [] segments ()                 // сегменты линии
}

