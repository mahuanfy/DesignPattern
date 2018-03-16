import color.Color;
        import color.impl.Green;
        import color.impl.Red;
        import shape.impl.Circular;
        import shape.impl.Rectangle;
        import shape.Shape;

public class FactoryPattern {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = new ShapeFactory();
        Shape circular = shapeFactory.getClass(Circular.class);
        circular.manufacture();
        Shape rectangle = shapeFactory.getClass(Rectangle.class);
        rectangle.manufacture();
        AbstractFactory colorFactory = new ColorFactory();
        Color green = colorFactory.getClass(Green.class);
        green.fill();
        Color red = colorFactory.getClass(Red.class);
        red.fill();

    }
}
