//nơi vẽ các hình đồ họa
package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Drawer {
    public final static ImageView loadImageIcon (Image image, double posX, double posY) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth());
        imageView.setFitHeight(image.getHeight());
        imageView.setX(posX);
        imageView.setY(posY);
        return imageView;

    }
}
