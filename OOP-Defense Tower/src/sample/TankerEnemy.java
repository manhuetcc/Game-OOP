package sample;

public class TankerEnemy extends Enemy {


    public TankerEnemy (String urlImage, double x, double y) {
        super(urlImage, x, y);
        speed = 0.5;
        heart = 12;
    }

}
