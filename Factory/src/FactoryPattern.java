public class FactoryPattern {

    public static void main(String[] args) {
        Shape circular = Factory.getClass(Circular.class);
        circular.Manufacture();
        Shape rectangle = Factory.getClass(Rectangle.class);
        rectangle.Manufacture();
    }
}
