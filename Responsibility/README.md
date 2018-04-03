### java设计模式——责任链模式
#### 1.责任链模式（Chain of Responsibility）
责任链模式是一种设计模式。在责任链模式里，很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织和分配责任。


#### 2.代码实现

>场景：当我们计算某个数的阶乘的时候，小的数据就可以用int来接收，稍微大点的用long来接收，再大一点的用BigInterger来接收。

- 处理者接口（Handler）
```
public interface Handler {

    /**
     * 传入一个数字类型的字符串，最后将其转换为需要的类型
     * @param number
     */
    void compuerMultiply(String number);

    /**
     * 指定下一个处理者
     * @param handler
     */
    void setNextHandler(Handler handler);
}

```
- 具体处理者（useInt）
```
public class UseInt implements Handler {
    private Handler handler;
    private int result=1;
    @Override
    public void compuerMultiply(String number) {
        try{
            int n = Integer.parseInt(number);
            int i = 1;
            while(i<=n){
                result *=i;
                if(result<=0){
                    System.out.println("超出int的能力范围，int计算不了了");
                    handler.compuerMultiply(number);
                    return;
                }
                i++;
            }
            System.out.println(number+"的阶乘"+result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}

```
- 具体处理者（useLong）
```
public class UseLong implements Handler {
    private Handler handler;
    private long result=1;
    @Override
    public void compuerMultiply(String number) {
        try{
            long n = Long.parseLong(number);
            long i = 1;
            while(i<=n){
                result *=i;
                if(result<=0){
                    System.out.println("超出long的能力范围，long计算不了了");
                    handler.compuerMultiply(number);
                    return;
                }
                i++;
            }
            System.out.println(number+"的阶乘"+result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}

```
- 具体处理者（UseBigInterger）
```
import java.math.BigInteger;

public class UseBigInterger implements Handler {
    private Handler handler;
    private BigInteger result=new BigInteger("1");
    @Override
    public void compuerMultiply(String number) {
        try{
            BigInteger n =new BigInteger(number);
            BigInteger one =new BigInteger("1");
            BigInteger i = one ;
            while(i.compareTo(n)<=0){
                result =result.multiply(i);
                i = i.add(one );
            }
            System.out.println(number+"的阶乘"+result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}

```
- 执行Main方法
```
public class Main {

    public static void main(String[] args) {
        Handler useInt,useLong,useBig;
        useInt = new UseInt();
        useLong = new UseLong();
        useBig = new UseBigInterger();
        useInt.setNextHandler(useLong);
        useLong.setNextHandler(useBig);
        useInt.compuerMultiply("5");
        useInt.compuerMultiply("19");
        useInt.compuerMultiply("30");
    }
}

```
- 运行结果：

![](https://upload-images.jianshu.io/upload_images/1616232-0996df3e1aeddeb0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>- 优点
1、降低耦合度。它将请求的发送者和接收者解耦。 
2、简化了对象。使得对象不需要知道链的结构。 
3、增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。
4、增加新的请求处理类很方便。
>- 缺点：
1、不能保证请求一定被接收。 
2、系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 
3、可能不容易观察运行时的特征，有碍于除错。
>- 使用场景： 
1、有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定。 
2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。 
3、可动态指定一组对象处理请求。
(总结参考：菜鸟教程)
