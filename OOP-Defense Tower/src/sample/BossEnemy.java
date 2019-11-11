package sample;

public class BossEnemy extends Enemy {
    public BossEnemy (String urlImage, double x, double y) {
        super(urlImage, x, y);
        speed = 0.5;
        heart = 20;
    }
}
