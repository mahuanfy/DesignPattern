### java设计模式——抽象工厂模式

#### 1.抽象工厂模式（Abstract Factory Pattern）

抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

![](https://upload-images.jianshu.io/upload_images/1616232-d8bcb3579f2b5d59.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2.代码实现

>场景：现在有要使用一个超级工厂创建两个工厂，一个工厂制造模具，一个工厂制造颜料。

- 颜料工厂（Color）：

```
public interface Color {
    void fill ();
}
```
- 红颜色：

```
import color.Color;
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("制造一个红颜色");
    }
}
```
- 灰色：

```
import color.Color;
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("制造一个灰颜色");
    }
}
```
- 模具工厂（Shape）:

```
public interface Shape {
    /**
     * 制造各种形状模型
     */
    void manufacture();
}
```
- 圆形：

```
public class Circular implements Shape {

    @Override
    public void manufacture() {
        System.out.println("我是制造的圆形模具！");
    }
}
```
- 矩形：

```
public class Rectangle implements Shape {
    @Override
    public void manufacture() {
        System.out.println("我是制造的矩形模具");
    }
}
```
--- 
- 制造颜色工厂(ColorFactory):

```
import color.Color;

public class ColorFactory implements AbstractFactory{
    Color obj = null;
    @Override
    public Color getClass(Class clazz){
        try {
            obj = (Color) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void fill(){
        this.obj.fill();
    }
}
```
- 制造模具工厂(ShapeFactory):

```
import shape.Shape;
public class ShapeFactory implements AbstractFactory{
    Shape obj = null;
    @Override
    public Shape getClass(Class clazz){
        try {
            obj = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void manufacture() {
        this.obj.manufacture();
    }
    
}
```
- 制造工厂接口(AbstractFactory)：

```
public interface AbstractFactory {
    <T> T getClass(Class<? extends T> clazz);
}
```
- 抽象模式制造物品(FactoryPattern):

```
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

```
- 运行结果：

![](https://upload-images.jianshu.io/upload_images/1616232-d6c979c0f8c15d47.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>- 优点
当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
>- 缺点：
产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
>- 使用场景： 
 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
>(总结参考：菜鸟教程)
