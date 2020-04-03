package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class GameDialog extends Stage {

    private Text textQuestion = new Text();
    private TextField fieldAnswer = new TextField();
    private Text textActualAnswer = new Text();

    private boolean correct = false;

    String[] QuestionArray = new String[]{
            "Pytanie1",
            "Pytanie2",
            "Pytanie3",
            "Pytanie4",
            "Pytanie5",
            "Pytanie6",
            "Pytanie7",
            "Pytanie8",
            "Pytanie9",
            "Pytanie10"
    };
    String[] AnswerArray = new String[]{
            "Odp1",
            "Odp2",
            "Odp3",
            "Odp4",
            "Odp5",
            "Odp6",
            "Odp7",
            "Odp8",
            "Odp9",
            "Odp10"
    };

    public int GenerateNumber(){
        int number;
        Random generator = new Random();
        number = generator.nextInt(10);
        return number;
    }


    public GameDialog() {
        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(event -> {
            fieldAnswer.setEditable(false);
            textActualAnswer.setVisible(true);
            correct = textActualAnswer.getText().equals(fieldAnswer.getText().trim());
        });




        VBox vbox = new VBox(10, textQuestion, fieldAnswer, textActualAnswer, btnSubmit);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);

        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
    }

    public void open() {
        int number = GenerateNumber();
        textQuestion.setText(QuestionArray[number]);
        fieldAnswer.setText("");
        fieldAnswer.setEditable(true);
        textActualAnswer.setText(AnswerArray[number]);
        textActualAnswer.setVisible(false);

        show();
    }

    public boolean isCorrect() {
        return correct;
    }
}