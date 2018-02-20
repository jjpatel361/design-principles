interface Shape{
    def Area();
}

class Reactangle implements Shape{
    def width
    def height
    
    def Area() {
        return width*height
    }
}

class Triangle implements Shape{
    def base
    def height

    def Area() {
        return 0.5 * base * height;
    }
}

class Circle implements Shape {
    def radius 

    def Area() {
        return 3.14*radius*radius; 
    }
}

static main(args) {
    println('Open Close example')
    Reactangle r = new Reactangle();
    r.width = 10;
    r.height = 20;
    println('Reactangle Area : ' + r.Area())

    Triangle t = new Triangle();
    t.base = 10;
    t.height = 20;
    println('Triangle Area : ' + t.Area())

    Circle c = new Circle();
    c.radius = 3;

    def shapes = [t, r, c];

    for (shape in shapes) {
        println(shape.Area())
    }



}