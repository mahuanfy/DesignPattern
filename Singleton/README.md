### java设计模式——代理模式

#### 1.单例模式（Singleton Pattern）
单例模式，是一种常用的软件设计模式。在它的核心结构中只包含一个被称为单例的特殊类。通过单例模式可以保证系统中，应用该模式的类一个类只有一个实例。即一个类只有一个对象实例。
![](https://upload-images.jianshu.io/upload_images/1616232-91eeb05e487ad26e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2.代码实现
>用大臣每次上朝见皇帝这件事来模拟这个单例模式，场景如下。

- 皇帝这个类
```
public class Emperor {
    private static final Emperor emperor = new Emperor();
    static int count = 0;
    private Emperor(){};

    public synchronized static Emperor getEmperor(){
        count ++;
        return emperor;
    }

    public void emperorInfo(){
        System.out.println("第"+count+"次上朝");
        System.out.println("雍正皇帝");
    }
}

```
- 大臣这个类
```
public class Minister {

    public static void main(String[] args) {
        Emperor emperor1 = Emperor.getEmperor();
        emperor1.emperorInfo();
        Emperor emperor2 = Emperor.getEmperor();
        emperor2.emperorInfo();
        Emperor emperor3 = Emperor.getEmperor();
        emperor3.emperorInfo();
        Emperor emperor4 = Emperor.getEmperor();
        emperor4.emperorInfo();
    }
}

```
- 运行结果：

![](https://upload-images.jianshu.io/upload_images/1616232-aabb4ec931e74ee1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- 注意:

当然皇帝也是会换届，而且也存在两个皇帝同时存在的时期，暂且忽略此细节，且认为皇帝就是一个单例模式。

>- 优点
 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）
>2、避免对资源的多重占用（比如写文件操作）。
>- 缺点：
没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
>- 使用场景： 
1、要求生产唯一序列号。 
2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 
3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
(总结参考：菜鸟教程)
