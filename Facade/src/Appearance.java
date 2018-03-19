/**
 * Created by 马欢欢 on 2018/3/19.
 */
public class Appearance {
    private LetterProcess sendMaiPersonl = new SendMaiPersonl();

    public void sendLetter(String context,String address){
        this.sendMaiPersonl.write(context);
        this.sendMaiPersonl.envelope(address);
        this.sendMaiPersonl.postoffice();
        this.sendMaiPersonl.sendMail();
    }

}
