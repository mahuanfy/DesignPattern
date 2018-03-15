### java设计模式——工厂模式

#### 1.工厂模式（Factory Pattern）

工厂模式是我们最常用的实例化对象模式了，是用工厂方法代替new操作的一种模式。在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
![](https://upload-images.jianshu.io/upload_images/1616232-ff03d76e3c9eb51e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2.代码实现

> 场景：工厂在制造模具时，会使用统一的工具，当你输入你需要的形状时，就会制造出对应的形状。

- 形状接口：

```
public interface Shape {
    /**
     * 制造各种形状模型
     */
    void Manufacture();
}

```
- 圆形模型

```
public class Circular implements Shape{

    @Override
    public void Manufacture() {
        System.out.println("我是制造的圆形模具！");
    }
}

```
- 矩形模型

```
public class Rectangle implements Shape {
    @Override
    public void Manufacture() {
        System.out.println("我是制造的矩形模具");
    }
}

```
- 制造工具

```
/**
 * Created by 马欢欢 on 2018/3/15.
 */
public class Factory {
    public static <T> T getClass(Class<? extends T> clazz){
        T obj = null;

        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
```
- 工厂

```
public class FactoryPattern {

    public static void main(String[] args) {
        Shape circular = Factory.getClass(Circular.class);
        circular.Manufacture();
        Shape rectangle = Factory.getClass(Rectangle.class);
        rectangle.Manufacture();
    }
}

```
- 运行结果：

![](https://upload-images.jianshu.io/upload_images/1616232-5a7386917554fd22.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


>- 优点:
1、一个调用者想创建一个对象，只要知道其名称就可以了。
2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 
3、屏蔽产品的具体实现，调用者只关心产品的接口。
>- 缺点：
每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
>- 使用场景：  
1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。 
3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。
(总结参考：菜鸟教程)
