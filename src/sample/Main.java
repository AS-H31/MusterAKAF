package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage pStage) throws Exception{
        Parent login_parent = FXMLLoader.load(getClass().getResource("../resources/login.fxml"));
        pStage.setTitle("AkafoeApp");
        pStage.setScene(new Scene(login_parent, 600, 400));
        pStage.initStyle(StageStyle.DECORATED);
        pStage.setResizable(false);
        pStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
