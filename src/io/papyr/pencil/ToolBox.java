package io.papyr.pencil;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ToolBox extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Toolbox");
        Scene scene = new Scene(new VBox(20));
        VBox box = (VBox) scene.getRoot();
        box.setPadding(new Insets(5, 5, 5, 5));
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setPrefWidth(200);
        colorPicker.setValue(Color.CORAL);
        colorPicker.setOnAction(t -> Data.selectedColor = colorPicker.getValue());
        final Button save = new Button("Save");
        save.setPrefWidth(200);
        save.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                // save
                IOBox.pack();
            }
        });
        box.getChildren().addAll(colorPicker, save);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
