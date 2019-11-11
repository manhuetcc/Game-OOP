package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Enemy implements GameEntity {
    protected String urlImage;
    protected double posX;
    protected double posY;
    protected double width;
    protected double height;
    protected double speed;
    protected double heart;

    public Enemy () {

    }

    public Enemy (String urlImage, double x, double y) {
        this.urlImage = urlImage;
        this.posX = x;
        this.posY = y;
    }

    public ImageView initEnemy() {
        Image image = new Image(this.getURLImage());
        ImageView imageEnemy = Drawer.loadImageIcon(image, this.posX, this.posY);
        this.setWidthHeight(image.getWidth(), image.getHeight());
        return imageEnemy;
    }

    public void moveEnemy() {
        if (posY == Map.rotary1.getY() && (posX < Map.rotary1.getX())) {
            posX += speed;
        }
        if (posX == Map.rotary2.getX() && (posY > Map.rotary2.getY())) {
            posY -= speed;
        }
        if (posY == Map.target.getY() && (posX < Map.target.getX())) {
            posX += speed;
        }
    }
        public double rotateEnemy() {
            if (posY > Map.rotary2.getY() && (posX == Map.rotary2.getX()))
                return 270;
            //if (posX == Map.target.getX() && (posY == Map.target.getY()))

            return 0;
        }
        public static boolean checkPos(Enemy enemy) {
            if(enemy.posX == Map.target.getX() && (enemy.posY == Map.target.getY())) {
                return true;
            }
            return false;
        }
        public static boolean checkHeart(Enemy enemy) {
            if (enemy.heart <= 0)
                return true;
            return false;
        }


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
