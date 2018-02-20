class Reactangle{
    def width
    def height
}

class Triangle{
    def base
    def height
} 

class AreaCalculator{
    
    def Area(Object r) {
        if (r in Reactangle) {
            int area = r.width * r.height;
            return area;
        }
        if (r in Triangle){
            int area = 0.5* r.base * r.height;
            return area;
        } 
    } 
}

static main(args) {
    Reactangle r = new Reactangle();
    r.width = 2;
    r.height = 4;

    AreaCalculator calc = new AreaCalculator();
    def area_calculated = calc.Area(r);
    println('Reactangle Area : '+ area_calculated)

    Triangle t = new Triangle();
    t.base = 2;
    t.height = 3;

    def area_triangle = calc.Area(t);
    println "Area of triangle :" + area_triangle
    

}