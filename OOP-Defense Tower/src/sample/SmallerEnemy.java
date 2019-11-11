package sample;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy (String urlImage, double x, double y) {
        super(urlImage, x, y);
        speed = 2;
        heart = 2;
    }
}
