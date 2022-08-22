package view;

import com.example.conway.model.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class GameBoardView extends BorderPane {
    private final int ImageSize = 40;
    private final GameBoard Board;
    public AnimationTimer gameLoop;

    public GameBoardView(Stage stage) {
        this.Board = new GameBoard(3, 3);
        setPrefSize(Board.getRows() * ImageSize,
                Board.getColumns() * ImageSize);
        for (int i = 0; i < this.Board.getRows(); i++) {
            for (int j = 0; j < this.Board.getColumns(); j++) {
                createCellView(i, j);
            }
        }
    }

    private void createCellView(int i, int j) {
        int layoutX = i * ImageSize;
        int layoutY = j * ImageSize;
        CellView cellView = new CellView(ImageMethod.ImageFromCell(this.Board.getCell(i,j)), layoutX, layoutY);
        getChildren().add(cellView);
    }

    private void update() {
        for (int i = 0; i < this.Board.getRows(); i++) {
            for (int j = 0; j < this.Board.getColumns(); j++) {
                getChildren().remove(Board.getCell(i,j));
                createCellView(i,j);
            }
        }
    }

    public void buildAndSetGameLoop() {
        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;
            public void handle(long now) {
                if ((now - lastUpdate) >= TimeUnit.MILLISECONDS.toNanos(500)) {
                    Board.updateGrid();
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