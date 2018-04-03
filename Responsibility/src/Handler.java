/**
 * Created by 马欢欢 on 2018/4/3.
 */
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
