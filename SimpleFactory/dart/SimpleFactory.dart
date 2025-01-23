abstract class Shape {
  void draw();
}

class Circle implements Shape {
  @override
  void draw() => print("drawing a Circle");
}

class Triangle implements Shape {
  @override
  void draw() => print("drawing a Triangle");
}

class Rectangle implements Shape {
  @override
  void draw() => print("drawing a Rectangle");
}

class ShapeFactory {
  static Shape creatShape(String shapeName) {
    return switch (shapeName.toLowerCase()) {
      "circle" => Circle(),
      "triangle" => Triangle(),
      "rectangle" => Rectangle(),
      _ => throw Exception("there is no shape with the provided name"),
    };
  }
}

void draw(Shape sh) => sh.draw();

void main() {
  final circle = ShapeFactory.creatShape("circle");
  final triangle = ShapeFactory.creatShape("triangle");
  final rectangle = ShapeFactory.creatShape("rectangle");
  [circle, triangle, rectangle].forEach(draw);
  // drawing a Circle
  // drawing a Triangle
  // drawing a Rectangle
}
