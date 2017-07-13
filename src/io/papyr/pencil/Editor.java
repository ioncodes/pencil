package io.papyr.pencil;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Editor extends Application {
    private Tile[][] map;
    private Pane root = new Pane();

    private Parent drawGrid(int x, int y, int w, int h) {
        map = new Tile[x][y];
        root.setPrefSize((x * w) + 1, (y * h) + 1);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Tile tile = new Tile(w,h);
                tile.setTranslateX(j * w);
                tile.setTranslateY(i * h);
                root.getChildren().add(tile);
                map[j][i] = tile;
            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(drawGrid(Data.amountX,Data.amountY,Data.width,Data.height)));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    private class Tile extends StackPane {
        public Tile(int w, int h) {
            Rectangle border = new Rectangle(w, h);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(border);
            setOnMouseClicked(event -> {
               if (event.getButton() == MouseButton.PRIMARY) {
                    border.setFill(Data.selectedColor);
                } else if(event.getButton() == MouseButton.SECONDARY) {
                   border.setFill(null);
               }
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
