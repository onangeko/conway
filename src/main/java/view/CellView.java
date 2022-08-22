package view;

import com.example.conway.model.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellView extends ImageView {

    public CellView(Image image) {
        super(image);
    }




    public CellView(Image image, int x, int y) {
        this(image);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}



