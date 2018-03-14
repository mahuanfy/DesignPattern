/**
 * Created by 马欢欢 on 2018/3/14.
 */
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
