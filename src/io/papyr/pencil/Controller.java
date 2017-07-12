package io.papyr.pencil;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
    @FXML
    Pane paintGrid;
    int n = 10;
    double width = 300/n;
    Rectangle[][] rec = new Rectangle [n][n];

    public void initialize() {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rec[i][j] = new Rectangle();
                rec[i][j].setX(i * width);
                rec[i][j].setY(j * width);
                rec[i][j].setWidth(width);
                rec[i][j].setHeight(width);
                rec[i][j].setFill(null);
                rec[i][j].setStroke(Color.BLACK);
                paintGrid.getChildren().add(rec[i][j]);
            }
        }
    }

    public void mark(MouseEvent me) {
        double posX = me.getX();
        double posY = me.getY();

        int colX = (int)(posX / width);
        int colY = (int) (posY / width);

        rec[colX][colY].setFill(Color.RED);
    }
}
