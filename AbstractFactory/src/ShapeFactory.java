import shape.Shape;

/**
 * Created by 马欢欢 on 2018/3/15.
 */
public class ShapeFactory implements AbstractFactory{
    Shape obj = null;
    @Override
    public Shape getClass(Class clazz){
        try {
            obj = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void manufacture() {
        this.obj.manufacture();
    }
    
}
