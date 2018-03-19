/**
 * Created by 马欢欢 on 2018/3/19.
 */
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
