package io.papyr.pencil;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by lucam on 13.07.2017.
 */
public class Main extends Application {
    public static void main(String[] args) {
        Platform.runLater(() -> {
            try {
                Dialog<List<String>> dialog = new Dialog<>();
                dialog.setTitle("Map Info");
                ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
                GridPane gridPane = new GridPane();
                TextField width = new TextField(String.valueOf(Data.width));
                TextField height = new TextField(String.valueOf(Data.height));
                TextField x = new TextField(String.valueOf(Data.amountX));
                TextField y = new TextField(String.valueOf(Data.amountY));
                gridPane.add(width, 0, 0);
                gridPane.add(height, 0, 1);
                gridPane.add(x, 0, 2);
                gridPane.add(y, 0, 3);
                dialog.getDialogPane().setContent(gridPane);
                Platform.runLater(width::requestFocus);
                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == loginButtonType) {
                        return Arrays.asList(width.getText(), height.getText(), x.getText(), y.getText());
                    }
                    return null;
                });
                Optional<List<String>> result = dialog.showAndWait();
                result.ifPresent(r -> {
                    Data.width = Integer.parseInt(r.get(0));
                    Data.height = Integer.parseInt(r.get(1));
                    Data.amountX = Integer.parseInt(r.get(2));
                    Data.amountY = Integer.parseInt(r.get(3));
                });
                new Editor().start(new Stage());
                new ToolBox().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
