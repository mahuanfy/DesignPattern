import java.math.BigInteger;

/**
 * Created by 马欢欢 on 2018/4/3.
 */
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
