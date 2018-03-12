### java设计模式——代理模式
#### 1.代理模式（Proxy Pattern）
为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个对象不适合或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
>下面举个简单的例子来说明问题：简单来说就例如经销商找明星代言，首先会找到经纪公司，经济公司再去让艺人去代言等。

![UML类图](https://upload-images.jianshu.io/upload_images/1616232-c67e5019704186f2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

--- 
#### 2.代码实现：
>创建一个接口
```
public interface Subject {
    /**
     * 做广告
     */
    void Advertising();

    /**
     * 开演唱会
     */
    void OpenAConcert();
}
```
> 创建一个经经纪公司的类，来实现这个接口
```

public class Brokerage implements Subject {
    private Star star;

    public Brokerage(Star star){
        this.star = star;
    }
    @Override
    public void Advertising() {
        this.star.Advertising();
    }

    @Override
    public void OpenAConcert() {
        this.star.OpenAConcert();
    }
}
```
>创建一个明星来做代言或者开演唱会
```

public class Star implements Subject {
    @Override
    public void Advertising() {
        System.out.println("我是明星甲，要去代言！");
    }

    @Override
    public void OpenAConcert() {
        System.out.println("我是明星甲，我要开演唱会！");
    }
}

```
>最后创建一个经销商，来雇用明星代言
```
public class Sponsor {

    public static void main(String[] args) {
        Brokerage brokerage = new Brokerage(new Star());
        brokerage.Advertising();
        brokerage.OpenAConcert();
    }
}
```
>运行结果

![结果](https://upload-images.jianshu.io/upload_images/1616232-b20ad80f4302974d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 注意：当然一个经纪公司不止一个艺人，也可以有多个艺人。经纪公司就相当于是代理类，明星就相当于是被代理类，代理类主要是来接活，并不会去干，接到活交给被代理类去干。

---
>优缺点：
>- 优点： 
1、职责清晰。 
2、高扩展性。
3、智能化。
>- 缺点： 
1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。 
2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。