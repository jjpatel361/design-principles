class ShapeFactory{
    def getNewShape() {
        return new Square();
    }
}

class Rectangle{
    def width;
    def height;

    def setWidth(int w) {this.width = w}

    def setHeight(int h) {this.height = h}

    def area() {
        return this.height * this.width;
    }
}


class Square extends Rectangle{
    def setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h);
    }

    def setWidth(int w) {
        super.setHeight(w);
        super.setWidth(w);
    }

}




static main(args) {
    ShapeFactory factory = new ShapeFactory();    
    Rectangle r  = factory.getNewShape();
    r.setHeight(10);
    r.setWidth(20);
    println('Area of Rectangle : '  + r.area())
}