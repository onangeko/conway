package view;

import model.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

import java.util.concurrent.TimeUnit;

public class GameBoardView extends BorderPane {
    private final int ImageSize = 40;
    private final GameBoard Board;
    public AnimationTimer gameLoop;

    public GameBoardView() {
        this.Board = new GameBoard(15, 15); //default size is 15x15
        setPrefSize(Board.getRows() * ImageSize,
                Board.getColumns() * ImageSize);
        for (int i = 0; i < this.Board.getRows(); i++) {
            for (int j = 0; j < this.Board.getColumns(); j++) {
                createCellView(i, j);
            }
        }
    }

    private void createCellView(int i, int j) { // create a render for each cell
        int layoutX = i * ImageSize;
        int layoutY = j * ImageSize;
        CellView cellView = new CellView(ImageMethod.ImageFromCell(this.Board.getCell(i,j)), layoutX, layoutY);
        getChildren().add(cellView);
    }

    private void update() { //handle the graphic update
        for (int i = 0; i < this.Board.getRows(); i++) {
            for (int j = 0; j < this.Board.getColumns(); j++) {
                getChildren().remove(Board.getCell(i,j));
                createCellView(i,j);
            }
        }
    }

    public void buildAndSetGameLoop() { //
        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;
            public void handle(long now) { // updates happens once every seconds
                if ((now - lastUpdate) >= TimeUnit.MILLISECONDS.toNanos(500)) {
                    // do actions
                    Board.updateGrid();
                    //graphic update
                    update();
                    lastUpdate = now;
                }

            }
        };
    }

    public void start() {
        gameLoop.start();
    }

}