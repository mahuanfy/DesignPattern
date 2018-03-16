import color.Color;

public class ColorFactory implements AbstractFactory{
    Color obj = null;
    @Override
    public Color getClass(Class clazz){
        try {
            obj = (Color) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void fill(){
        this.obj.fill();
    }
}
