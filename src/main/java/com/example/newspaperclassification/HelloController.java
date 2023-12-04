package com.example.newspaperclassification;

import com.example.testing.NaiveBayes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextArea textArea;

    @FXML
    private Label classificationLabel;

    @FXML
    protected void onClassifyButtonClick() {
       String inputText =  textArea.getText();
        System.out.println("Input text is: "+inputText);

        NaiveBayes naiveBayes = new NaiveBayes();
        String classification =  naiveBayes.returnClassification(inputText);

        classificationLabel.setText(classification);
    }

    @FXML
    protected void textFieldController(){
        classificationLabel.setText("");
    }

    @FXML
    protected void addTrainingSectionCheckBox(){
        System.out.println("Check box clicked");
    }
}