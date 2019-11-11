package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet implements GameEntity {
    private String urlImage;
    private double posX;
    private double posY;
    private double posXDefault;
    private double posYDefault;
    private double width;
    private double height;
    private double speedBullet;
    // private double damage;
    private double range;

    public Bullet (Tower tower) {
        double x = tower.getX() - tower.getWidth() / 2;
        double y = tower.getY() - tower.getHeight() / 2;
        this.posX = x;
        this.posY = y;
        this.posXDefault = x;
        this.posYDefault = y;
        this.range = tower.range;
    }

    public Bullet (String urlImage, double x, double y, double range) {
        this.urlImage = urlImage;
        this.posX = x;
        this.posY = y;
        this.range = range;
    }

    public void setSpeedBullet(double speedBullet) {
        this.speedBullet = speedBullet;
    }

    public double getSpeedBullet() {
        return speedBullet;
    }

    public void moveBullet( double enemy_CenterX, double enemy_CenterY, double range) {
        double a = this.posXDefault - enemy_CenterX;
        double b = this.posYDefault - enemy_CenterY;

        double c = enemy_CenterX - this.posX;
        double d = enemy_CenterY - this.posY;

        double distance = Math.sqrt(a*a + b*b);
        if (distance < range) {
            if (this.posX > enemy_CenterX) {
                this.posX -= speedBullet;
            } else if (this.posX < enemy_CenterX) {
                this.posX += speedBullet;
            }
            this.posY = (d / c) * (this.posX - enemy_CenterX) + enemy_CenterY;
        }
        if (distance >= range) {
            this.posX = this.posXDefault;
            this.posY = this.posYDefault;
        }
    }

    public boolean checkContact(Enemy enemy) {
        double left_Bullet = this.getX();
        double right_Bullet = this.getX() + this.getWidth();
        double top_Bullet = this.getY();
        double bottom_Bullet = this.getY() + this.getHeight();

        double left_Enemy = enemy.getX();
        double right_Enemy =  enemy.getX() +  enemy.getWidth();
        double top_Enemy = enemy.getY();
        double bottom_Enemy = enemy.getY() + enemy.getHeight();

        if (left_Bullet > left_Enemy && left_Bullet < right_Enemy)
        {
            if (top_Bullet > top_Enemy && top_Bullet < bottom_Enemy)
            {
                return true;
            }
        }

        if (left_Bullet > left_Enemy && left_Bullet < right_Enemy)
        {
            if (bottom_Bullet > top_Enemy && bottom_Bullet < bottom_Enemy)
            {
                return true;
            }
        }

        if (right_Bullet > left_Enemy && right_Bullet < right_Enemy)
        {
            if (top_Bullet > top_Enemy && top_Bullet < bottom_Enemy)
            {
                return true;
            }
        }

        if (right_Bullet > left_Enemy && right_Bullet < right_Enemy)
        {
            if (bottom_Bullet > top_Enemy && bottom_Bullet < bottom_Enemy)
            {
                return true;
            }
        }

        return false;
    }

    public void resetBullet() {
        this.posX = this.posXDefault;
        this.posY = this.posYDefault;
    }

    public ImageView initBullet() {
        Image image = new Image(this.getURLImage());
        ImageView imageBullet = Drawer.loadImageIcon(image, this.posX, this.posY);
        this.setWidthHeight(image.getWidth(), image.getHeight());
        return imageBullet;
    }

//    public void setPointBulletDefault(Tower tower) {
//        this.posXDefault = tower.getX() + tower.getWidth() / 2;
//        this.posYDefault = tower.getY() + tower.getHeight() / 2;
//    }

    @Override
    public void setImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public void setPositionXY(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void setWidthHeight(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double getX() {
        return posX;
    }

    @Override
    public double getY() {
        return posY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String getURLImage() {
        return this.urlImage;
    }
}
