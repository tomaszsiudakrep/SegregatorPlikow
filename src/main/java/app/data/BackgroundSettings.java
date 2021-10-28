package app.data;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BackgroundSettings {

    public static final String IMG_PATH = "file:src/main/resources";
    public static final int width = 626;
    public static final int height = 417;

    public Background defaultBackground() {
        ImageView imageViewMenu = new ImageView(IMG_PATH + "/menu.jpg");
        imageViewMenu.setPreserveRatio(true);
        BackgroundSize backgroundSizeMenu = new BackgroundSize(width, height, true, true, true, true);
        BackgroundImage backgroundImageMenu = new BackgroundImage(imageViewMenu.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeMenu);
        return new Background(backgroundImageMenu);
    }
}
