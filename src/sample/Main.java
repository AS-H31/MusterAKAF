package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage pStage) throws Exception{
        Parent login_parent = FXMLLoader.load(getClass().getResource("../resources/login.fxml"));
        pStage.setTitle("AkafoeApp");
        pStage.setScene(new Scene(login_parent, 600, 400));
        pStage.initStyle(StageStyle.UNDECORATED);
        pStage.setResizable(false);
        pStage.show();



        login_parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        login_parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pStage.setX(event.getScreenX() - xOffset);
                pStage.setY(event.getScreenY() - yOffset);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
