
public class Brokerage implements Subject {
    private Star star;

    public Brokerage(Star star){
        this.star = star;
    }
    @Override
    public void Advertising() {
        this.star.Advertising();
    }

    @Override
    public void OpenAConcert() {
        this.star.OpenAConcert();
    }
}
