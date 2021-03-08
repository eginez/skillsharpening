package org.eginez;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Set11 {
    //simple regex matching that supports '?' wild card
    public static boolean matches(String regex, String str) {

        if (regex.isEmpty() && str.isEmpty()) {
            return true;
        }

        if (regex.isEmpty() && !str.isEmpty()) {
            return false;
        }

        char currentRegex = regex.charAt(0);
        if (currentRegex == '?') {
            return str.isEmpty() || matches(regex.substring(1), str);
        }

        if (str.isEmpty()) {
            return matches(regex.substring(1), str);
        }

        char currentChar = str.charAt(0);
        if (currentChar == currentRegex) {
            return matches(regex.substring(1), str.substring(1));
        } else {
            //ab?c ac
            return matches(regex.substring(1), str);
        }
    }


    public static class Point {
        final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    };


    public static class Rectangle {
        final Point origin;
        final int h, w;

        public Rectangle(Point origin, int w, int h) {
            this.origin = origin;
            this.w = w;
            this.h = h;
        }

    };

    public static class Edge {
        int x, h;
        char type;

        public Edge(int x, int h, char type) {
            this.x = x;
            this.h = h;
            this.type = type;
        }

        public String toString() {
            return String.format("(%d, %d, %c)", x, h, type);
        }
    }

    public static List<Point> skyline(List<Rectangle> all) {

        List<Edge> edges = new ArrayList<>();
        List<Point> res = new ArrayList<>();

        //Adds begining and ends with heights
        for (Rectangle r : all) {
            edges.add(new Edge(r.origin.x, r.h, 's'));
            edges.add(new Edge(r.origin.x + r.w, r.h, 'e'));
        }

        edges.sort(Comparator.comparingInt((Edge e) -> e.x).thenComparingInt((Edge e) -> e.h));

        PriorityQueue<Integer> maxHs = new PriorityQueue<>(Comparator.reverseOrder());
        maxHs.add(0);

        //For each beginning and end, eval the highest point
        //in an end, remove the height and
        for (Edge e : edges) {
            int maxVal = maxHs.peek();
            if (e.type == 's') {
                maxHs.add(e.h);
                if (maxVal != maxHs.peek()) {
                    res.add(new Point(e.x, e.h));
                }
            } else {
                maxHs.remove(e.h);
                if (maxVal != maxHs.peek()) {
                    res.add(new Point(e.x, maxHs.peek()));
                }
            }
        }

        List<Point> joined = joinPoints(res);
        return joined;
    }

    //Joins all the points together.
    public static List<Point> joinPoints(List<Point> all) {
        List<Point> res = new ArrayList<>();
        res.add(new Point(0, 0));

        Point current = new Point(0, 0);
        for (Point p : all) {
            if (current.x != p.x) {
                current = new Point(p.x, current.y);
                res.add(current);
            }

            if (current.y != p.y) {
                current = new Point(current.x, p.y);
                res.add(current);
            }
        }
        return res;
    }
}
