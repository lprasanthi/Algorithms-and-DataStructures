class Point{
    public double x;
    public double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "( "+x+", "+y+" )";
    }
}
class Line{
    public double m;
    public double c;
    public Point start;
    public Point end;
    public Line(double m, double c){
        this.m = m;
        this.c = c;
    }
    public Line(Point start, Point end){
        this.start = start;
        this.end = end;
        if(end.x == start.x){
            m = Integer.MAX_VALUE;
            c = 0;
        }else {
            m = (end.y-start.y)/(end.x-start.x);
            c = end.y - (m*end.x);
        }
    }
}
class Square{
    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;
    public Point midPoint;
    public double side;
    public Square(Point p1, Point p2, Point p3, Point p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.midPoint = new Point((p1.x+p2.x)/2 , (p1.y+p3.y)/2);
    }
    public Line left(){
        return new Line(p1, p3);
    }
    public Line right(){
        return new Line(p2, p4);
    }
    public Line top(){
        return new Line(p3, p4);
    }
    public Line bottom(){
        return new Line(p1, p2);
    }
}
public class BisectSquare{
    private static Point findIntersection(Line l1, Line l2){
        if(l1.m == Integer.MAX_VALUE || l2.m == Integer.MAX_VALUE){
            double x = (l1.m == Integer.MAX_VALUE) ? l1.start.x : l2.start.x;
            double y =  (l1.m == Integer.MAX_VALUE) ? l2.m * x : l1.m * x;
            return new Point(x,y);
        }
        double x = (l2.c - l1.c) / (l1.m - l2.m);
        double y = (l1.m)*x + l1.c;
        return new Point(x,y);
    }
    public static double distance(Point p1, Point p2){
        return Math.sqrt((p2.y - p1.y)*(p2.y - p1.y) + (p2.x - p1.x)*(p2.x - p1.x));
    }
    public static Line Bisector(Square s1, Square s2){
        Point p1, p2, p3, p4;
        Line bisectorLine = new Line(s1.midPoint, s2.midPoint);
        System.out.println(s1.midPoint+","+s2.midPoint+" slope "+bisectorLine.m+" c "+bisectorLine.c);
        // If < 45degrees, line cuts vertical line if >45, line cuts horizontal line
        if(Math.abs(bisectorLine.m) < 1){
            p1 = findIntersection(bisectorLine, s1.left());
            p2 = findIntersection(bisectorLine, s1.right());
            p3 = findIntersection(bisectorLine, s2.left());
            p4 = findIntersection(bisectorLine, s2.right());
            return distance(p1, p4) > distance(p2, p3) ? new Line(p1, p4) : new Line(p2, p3);
        }else if(Math.abs(bisectorLine.m) > 1){
            p1 = findIntersection(bisectorLine, s1.top());
            p2 = findIntersection(bisectorLine, s1.bottom());
            p3 = findIntersection(bisectorLine, s2.top());
            p4 = findIntersection(bisectorLine, s2.bottom());
            return distance(p1, p4) > distance(p2, p3) ? new Line(p1, p4) : new Line(p2, p3);
        }else {
            if(s1.midPoint.x < s2.midPoint.x){
                return new Line(s1.p1, s2.p4);
            }
            return new Line(s2.p1, s1.p4);
        }
       
    }
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(5,1);
        Point p3 = new Point(1,5);
        Point p4 = new Point(5,5);
        Point p5 = new Point(10,9);
        Point p6 = new Point(16,9);
        Point p7 = new Point(10,15);
        Point p8 = new Point(16,15);
        Square s1 = new Square(p1,p2,p3,p4);
        Square s2 = new Square(p5,p6,p7,p8);
        Line l3 = Bisector(s1,s2);
        System.out.println(l3.start+", "+l3.end);
    }
}