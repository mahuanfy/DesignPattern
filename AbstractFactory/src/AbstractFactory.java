/**
 * Created by 马欢欢 on 2018/3/16.
 */
public interface AbstractFactory {
    <T> T getClass(Class<? extends T> clazz);
}
