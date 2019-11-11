package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Road implements GameTile {
    private String urlImage;
    private double posX;
    private double posY;
    public Road() {

    }

    public Road(String urlImage, double x, double y) {
        this.urlImage = urlImage;
        this.posX = x;
        this.posY = y;
        initRoad();
    }


    public void initRoad() {
        ImageView Road  =  Drawer.loadImageIcon(new Image(urlImage), posX, posY);
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
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public String getURLImage() {
        return urlImage;
    }
}
