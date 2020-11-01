package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controller_login {
    public TextField emailField = null;
    public TextField pwField = null;
    public Text error = null;

    // Methode for handling Login
    public void getLogInfo(ActionEvent actionEvent) throws IOException {
        error.setText("");
        String eingabe = "" ;

        BufferedReader emails = new BufferedReader(new FileReader("C:\\Users\\shiar\\IdeaProjects\\AkaApp\\src\\resources\\emails.txt"));
        while ((eingabe = emails.readLine())!= null){

            if (eingabe.equals(emailField.getText().trim().toLowerCase())){
                System.out.println("email vorhanden");
                // go to main view
                Parent home_parent = FXMLLoader.load(getClass().getResource("C:\\Users\\shiar\\IdeaProjects\\AkaApp\\src\\resources\\MainView.fxml"));
                Scene root = new Scene(home_parent);

                // this line gets Stage info
                /*
                when clicking on a button (here submit) the button returns an event, so event.getSource()
                gets the event source. After that we get the scene from the source event and then the window
                of our scene which will be our Stage.
                 */

                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setTitle("AkafoeApp");
                window.setScene(root);
                window.show();

            }else{
                error.setText("Email nicht vorhanden!");
            }
        }
        emailField.clear();
    }

}
