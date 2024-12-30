package prasartsri.yotsaphat.excersises;

class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        width = 5;
        height = 8;
    }

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public void print() {
        System.out.println("Regtangle width = " + width + " height = " + height);
    }
    public void doubleWidthHeight(){
        width =width *2;
        height =height *2;
    }
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.print();
        System.out.println("After calling method doubleWidthHeight()");
        r1.doubleWidthHeight();
        r1.print();
        
    }
}
