package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;
    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
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
