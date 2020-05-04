/* Point of intersection : point satisfied through both lines 
    y=m1x+c1 --> line 1
    y=m2x+c2 --> line 2
    m1x+c1 = m2x+c2
    x = (c2-c1)/(m1-m2);
    y = m1*x+c1;
    Calculate simultaneous equations.
*/
class Point{
    public double x;
    public double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public String toString() {
        return this.x+", "+this.y;
    }
    public int compareTo(Point p){
        if(this.x == p.x){
            return (int)this.y - (int)p.y;
        }
        return (int)this.x - (int)p.x;
    }
}
class Line{
    // y=mx+c;
    public double m;
    public double c;
    Point start;
    Point end;
    public Line(Point start, Point end){
        if(end.x == start.x){
            m = Integer.MAX_VALUE;
            c = 0;
        }else {
            m = (end.y-start.y)/(end.x-start.x);
            c = end.y - (m*end.x);
        }
    }
}
public class Intersection{
    private static boolean isBetween(double start, double middle, double end){
        return (start <= middle && middle <= end);
    }
    private static boolean isBetween(Point start, Point middle, Point end){
        return (isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y)) ||
        (isBetween(end.x, middle.x, start.x) && isBetween(end.y, middle.y, start.y));
    }
    public static Point intersection(Point start1, Point start2, Point end1, Point end2){
        if(start1.compareTo(end1) > 0)
            return intersection(end1, start2, start1, end2);
        if(start2.compareTo(end2) > 0)
            return intersection(start1, end2, end1, start2);
        if(start1.compareTo(start2) > 0)
            return intersection(start2, start1, end2, end1);
        
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);
        // parallel lines
        if(line1.m == line2.m) {
            // same line and overlap
            if(line1.c == line2.c && isBetween(start1,start2, end1)){
                return start2;
            }
            //diff line
            return null;  
        }
        if(line1.m == Integer.MAX_VALUE || line2.m == Integer.MAX_VALUE){
            double x = 0;
            double y = line1.m == Integer.MAX_VALUE ? line2.c : line1.c;
            return new Point(x,y);
        }
        double x = (line2.c - line1.c)/(line1.m-line2.m);
        double y = line2.m * start2.x + line2.c;
        return new Point(x,y);
    }
    public static void main(String[] args) {
        Point start1 = new Point(0,4);
        Point end1 = new Point(0,10);
        Point start2 = new Point(0,2);
        Point end2 = new Point(0,6);
        Point p = intersection(start1, start2, end1, end2);
        System.out.println(p);
    }
}