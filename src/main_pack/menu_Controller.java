package main_pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menu_Controller implements Initializable {
    public Label hello_user;
    public String USER;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        USER = null;
        Parent nextRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void single(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("single_layout.fxml"));
        Parent nextRoot = loader.load();
        single_Controller single_controller = loader.getController();
        single_controller.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void multi(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_1_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_1_Controller multi = loader.getController();
        multi.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void show_score(ActionEvent actionEvent) {
    }

    public void show_hero(ActionEvent actionEvent) {
    }
}
