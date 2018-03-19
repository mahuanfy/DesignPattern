/**
 * Created by 马欢欢 on 2018/3/19.
 */
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
