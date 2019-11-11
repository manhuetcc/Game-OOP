package sample;

public interface GameEntity {
    public void setImage(String urlImage);
    public void setPositionXY(double x, double y);
    public void setWidthHeight(double w, double h);
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public String getURLImage();
}
