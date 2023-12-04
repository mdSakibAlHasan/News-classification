package com.example.newspaperclassification;

import com.example.testing.NaiveBayes;
import com.example.testing.NewDataAdd;
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

    private boolean checkButtonClick=false;

    @FXML
    protected void onClassifyButtonClick() {
       String inputText =  textArea.getText();
        System.out.println("Input text is: "+inputText);

        NaiveBayes naiveBayes = new NaiveBayes();
        String classification =  naiveBayes.returnClassification(inputText);

        classificationLabel.setText(classification);
        checkButtonClick = false;
    }

    @FXML
    protected void textFieldController(){
        classificationLabel.setText("");
    }

    @FXML
    protected void addTrainingSectionCheckBox(){
        System.out.println("Check box clicked");
        if(classificationLabel.getText().length()>3 && textArea.getText().length()>200 && !checkButtonClick){
            NewDataAdd newDataAdd = new NewDataAdd();
            newDataAdd.writeData(textArea.getText(),classificationLabel.getText());
            checkButtonClick = true;
        }
        else{
            System.out.println("Length is very small");
        }

    }
}