package main_pack;

import game.PlatformGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopUp_Controller implements Initializable {
    public Label hello_user;
    public Label user_score;
    String USER;
    String HERO;
    int SCORE;
    Stage game_stage;


    public void set_hero(String herosik){
        HERO = herosik;
    }

    public void set_stage(Stage stage){
        game_stage = stage;
    }

    public void user_and_score(String user , int wynik){
        hello_user.setText(user);
        user_score.setText(String.valueOf(wynik));
        USER = user;
        SCORE = wynik;
    }


    public void save_score(ActionEvent actionEvent) {
    }

    public void go_to_menu(ActionEvent actionEvent) throws IOException {

    }

    public void try_again(ActionEvent actionEvent) throws Exception {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
