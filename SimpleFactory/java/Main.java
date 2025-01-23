interface Shape {
    public void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a Circle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a Triangle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a Rectangle");
    }
}

class ShapeFactory {
    public static Shape creatShape(String shapeName) {
        switch (shapeName.toLowerCase()) {
            case "circle":
                return new Circle();
            case "triangle":
                return new Triangle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("there is no shape with the provided name");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.creatShape("circle");
        Shape triangle = ShapeFactory.creatShape("triangle");
        Shape rectangle = ShapeFactory.creatShape("rectangle");
        circle.draw();// drawing a Circle
        triangle.draw();// drawing a Triangle
        rectangle.draw();// drawing a Rectangle
    }
}