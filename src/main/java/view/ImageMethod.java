package view;

import model.Cell;
import javafx.scene.image.Image;

public class ImageMethod {
    public static Image ImageFromCell(Cell cell){
        if (cell.isAlive()){
            return new Image("square.png");
        }else{
            return new Image("dead.png");
        }
    }
}
