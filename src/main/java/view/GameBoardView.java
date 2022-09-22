package view;

import connect.Connect;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.*;

import model.GridLoadSave;

public class    GameBoardView extends BorderPane {
    private final int ImageSize = 40;
    private GameBoard Board;


    private GridLoadSave gridLoadSave;

    private  MenuBar menuBar;

    public AnimationTimer gameLoop;


    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent clipboardContent = new ClipboardContent();
    public GameBoardView() {
        initialize();
    }

    private void initialize(){
        this.Board = new GameBoard(15, 15); //default size is 15x15
        setPrefSize(Board.getRows() * ImageSize,
                Board.getColumns() * ImageSize);
        for (int i = 0; i < this.Board.getRows(); i++) {
            for (int j = 0; j < this.Board.getColumns(); j++) {
                createCellView(i, j);
            }
        }
        setMenuBar();
        this.setTop(menuBar);


    }

    private void setMenuBar(){

        this.menuBar = new MenuBar();
        Menu fileMenu = new Menu("Options");


        MenuItem startGame = new MenuItem("Start Game");
        startGame.setOnAction(e -> {
            buildAndSetGameLoop();
            start();
        });

        MenuItem stopGame = new MenuItem("Stop Game");
        stopGame.setOnAction(e -> {
            gameLoop.stop();
        });

        MenuItem saveState  = new MenuItem("Save Game");
        saveState.setOnAction(e -> {
            gridLoadSave = new GridLoadSave();
            try {
                String Save = gridLoadSave.saveGridToString(Board.getGrid());
                Connect c = new Connect();
                String sql = "INSERT INTO saves (game) VALUES (?)";
                PreparedStatement statement = c.connect().prepareStatement(sql);
                statement.setString(1, Save);
                statement.executeUpdate();
                PreparedStatement statement2 = c.connect().prepareStatement("SELECT id FROM saves WHERE game = ?");
                statement2.setString(1, Save);
                ResultSet rs = statement2.executeQuery();
                exportDialog("Saved at state" + rs.getInt("id"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        MenuItem loadState = new MenuItem("Load Game");
        loadState.setOnAction(e -> {
            gridLoadSave = new GridLoadSave();
            try {
                String str = Form(new Stage(), "Select state id");
                Connect c = new Connect();
                String sql = "SELECT game FROM saves WHERE id = ?";
                PreparedStatement statement = c.connect().prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(str));
                ResultSet rs = statement.executeQuery();
                String game = rs.getString("game");
                Board.setGrid(gridLoadSave.loadGridFromString(game));
                update();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        fileMenu.getItems().addAll(startGame,stopGame,saveState,loadState);
        this.menuBar.getMenus().addAll(fileMenu);

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
                CellView cellView = (CellView) getChildren().get(i * this.Board.getRows() + j);
                cellView.setImage(ImageMethod.ImageFromCell(this.Board.getCell(i,j)));
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


    private void exportDialog(String msg) {
        clipboardContent.putString(msg);
        clipboard.setContent(clipboardContent);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export");
        alert.getDialogPane().setContent(new TextArea(msg));
        alert.setResizable(true);
        alert.showAndWait();
    }

    public String Form(Stage stage, String title) {
        GridPane pane = new GridPane();
        TextField gridString = new TextField();
        gridString.setPrefWidth(300);
        pane.setPadding(new Insets(25));
        pane.add(gridString,0,0);
        Stage dialog = new Stage();
        Scene scene = new Scene(pane);
        dialog.setTitle(title);
        dialog.setScene(scene);
        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        gridString.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                dialog.close();
            }
        });
        dialog.showAndWait();
        return gridString.getText();
    }

}