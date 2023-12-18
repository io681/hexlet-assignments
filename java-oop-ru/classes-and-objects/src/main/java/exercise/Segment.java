package exercise;

// BEGIN
public class Segment {
    Point beginPoint;
    Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        int midPointX = beginPoint.getX() + (endPoint.getX() - beginPoint.getX()) / 2;
        int midPointY = beginPoint.getY() + (endPoint.getY() - beginPoint.getY()) / 2;
        return  new Point(midPointX, midPointY);
    }
}
// END
