public class Main {

    public static void main(String[] args) {
        Handler useInt,useLong,useBig;
        useInt = new UseInt();
        useLong = new UseLong();
        useBig = new UseBigInterger();
        useInt.setNextHandler(useLong);
        useLong.setNextHandler(useBig);
        useInt.compuerMultiply("5");
        useInt.compuerMultiply("19");
        useInt.compuerMultiply("30");
    }
}
