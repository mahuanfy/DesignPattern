### java设计模式——外观模式

#### 1.外观模式（Facade Pattern）
外观模式 隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。
![](https://upload-images.jianshu.io/upload_images/1616232-c9c2605647e18ed7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2.代码实现

>场景：顾客在寄邮件时，只用关心邮件的内容和地址，不用去关心复杂的邮寄过程。

- 寄邮件过程接口（LetterProcess）
```
public interface LetterProcess {
    /**
     * 顾客写信
     * @param context
     */
    void write(String context);

    /**
     * 顾客填写邮寄地址
     * @param address
     */
    void envelope(String address);

    /**
     * 邮局进行邮件分类
     */
    void postoffice();

    /**
     * 邮局通过汽车送邮件
     */
    void sendMail();
}

```
- 实现寄件接口
```
public class SendMaiPersonl implements LetterProcess {
    @Override
    public void write(String context) {
        System.out.println("邮件内容："+context);
    }

    @Override
    public void envelope(String address) {
        System.out.println("邮件地址："+address);
    }

    @Override
    public void postoffice() {
        System.out.println("邮局通过省区分类邮件");
    }

    @Override
    public void sendMail() {
        System.out.println("邮局通过汽车派送邮件");
    }
}
```
- 外观模式(Appearance)
```
public class Appearance {
    private LetterProcess sendMaiPersonl = new SendMaiPersonl();

    public void sendLetter(String context,String address){
        this.sendMaiPersonl.write(context);
        this.sendMaiPersonl.envelope(address);
        this.sendMaiPersonl.postoffice();
        this.sendMaiPersonl.sendMail();
    }
}
```
- 顾客（Client）
```
public class Client {

    public static void main(String[] args) {
        Appearance appearance = new Appearance();
        appearance.sendLetter("愿你被这世界温柔以待,即使生命总以刻薄荒芜相欺","远方的朋友");
    }
}

```
- 运行结果：
![](https://upload-images.jianshu.io/upload_images/1616232-8386a0698775676d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>- 优点
 1、减少系统相互依赖。
 2、提高灵活性。
 3、提高了安全性。
>- 缺点：
不符合开闭原则，如果要改东西很麻烦，继承重写都不合适。
>- 使用场景： 
1、为复杂的模块或子系统提供外界访问的模块。
2、子系统相对独立。 
3、预防低水平人员带来的风险。
(总结参考：菜鸟教程)
