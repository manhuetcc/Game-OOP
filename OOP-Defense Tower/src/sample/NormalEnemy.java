package sample;

public class NormalEnemy extends Enemy {
    public NormalEnemy (String urlImage, double x, double y) {
        super(urlImage, x, y);
        speed = 1;
        heart = 9;
    }
}
