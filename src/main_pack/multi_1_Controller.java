package main_pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class multi_1_Controller implements Initializable {

    public Label hello_user;
    String USER;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
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

    public void multi(ActionEvent actionEvent) {
    }

    public void show_score(ActionEvent actionEvent) {
    }

    public void show_hero(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        USER = null;
        Parent nextRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }



    public void JennySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Jenny");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void AmySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Ammy");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void JonnySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Jonny");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void BobSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Bob");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void ZuluSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Zulu");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void FredSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("multi_2_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_2_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.player_1_hero("Fred");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
}
