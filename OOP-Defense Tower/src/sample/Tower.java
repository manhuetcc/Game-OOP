package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower implements GameTile {
    private String urlImage;
    private double posX;
    private double posY;
    private double width;
    private double height;
    public double range;

    public Tower() {

    }

    public Tower(String urlImage, double posX, double posY, double range) {
        this.urlImage = urlImage;
        this.posX = posX;
        this.posY = posY;
        this.range = range;
    }

    public ImageView initTower() {
        Image image = new Image(urlImage);
        ImageView imageTower = Drawer.loadImageIcon(image, this.posX, this.posY);
        this.setWidthHeight(image.getWidth(), image.getHeight());
        return imageTower;
    }

    @Override
    public void setImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public void setPositionXY(double x, double y) {
        posX = x;
        posY = y;
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
        return urlImage;
    }
}
