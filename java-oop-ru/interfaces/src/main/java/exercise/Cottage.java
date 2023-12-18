package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
    @Override
    public int compareTo(Home homeForCompare) {
        if (this.getArea() > homeForCompare.getArea()) {
            return 1;
        } else if (this.getArea() < homeForCompare.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
