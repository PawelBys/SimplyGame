package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EndGame extends Stage {
    public Text text;
    Button btnSave;
    Button btnMenu;
    Button btnTryAgain;


    public void createWindow(String user , int score){
        text.setText("Brawo  punktów");
        btnMenu = new Button("to menu");
        btnSave = new Button("save score");
        btnTryAgain = new Button("try again");

        VBox vbox = new VBox(10, text, btnMenu, btnSave, btnTryAgain);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);

        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);

    }
}
