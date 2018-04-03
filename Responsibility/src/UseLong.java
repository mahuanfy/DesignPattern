/**
 * Created by 马欢欢 on 2018/4/3.
 */
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
