package io.papyr.pencil;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ToolBox extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Toolbox");
        Scene scene = new Scene(new HBox(20));
        HBox box = (HBox) scene.getRoot();
        box.setPadding(new Insets(5, 5, 5, 5));

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setPrefWidth(200);
        colorPicker.setValue(Color.CORAL);
        colorPicker.setOnAction(t -> Data.selectedColor = colorPicker.getValue());

        box.getChildren().addAll(colorPicker);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
