package sample;

import javafx.geometry.Point2D;

public class Target implements GameTile {
    public static Point2D target = new Point2D(870, 89);

    @Override
    public void setImage(String urlImage) {
    }

    @Override
    public void setPositionXY(double x, double y) {
    }

    @Override
    public void setWidthHeight(double w, double h) {
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public String getURLImage() {
        return null;
    }
}
