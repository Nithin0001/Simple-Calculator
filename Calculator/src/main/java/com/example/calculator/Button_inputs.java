package com.example.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import java.net.URL;
//import java.util.ResourceBundle;

public class Button_inputs /*implements Initializable */{
    private double num1 = 0;
    private int operation, count = 0 ;
    private int equals_count = 0;
    Arithmetic_Logic logic = new Arithmetic_Logic();
    @FXML
    private Button sub;
    @FXML
    private Button mul;
    @FXML
    private Button division;
    @FXML
    private Button equals;
    @FXML
    private Button add;
    @FXML
    private Button square_root;
    @FXML
    private Button CLR;
    @FXML
    private Button del;
    @FXML
    private TextField text_field;
    @FXML
    private void handleButtonAction(ActionEvent event){
        String value = ((Button)event.getSource()).getText();//Getting the inputs.
        if(event.getSource() == del && !(text_field.getText().isEmpty())){ //del button logic -> if we click del and text field must not be empty only then a number must ber deleted.
            String letter = text_field.getText().substring(text_field.getLength() - 1, text_field.getLength());
           if(letter.equals("."))//for only one " . " be present in the text field at any given time
              count = 0;
           text_field.setText(text_field.getText().substring(0, text_field.getText().length()-1));
        }
        else if(event.getSource()==CLR){//clear text field button
             text_field.setText("");
             num1 = count = 0;
        }

        //taking only numbers!
        else if(event.getSource()!= del && event.getSource()!= add && event.getSource()!= equals && event.getSource()!= sub && event.getSource()!= mul && event.getSource()!= division && event.getSource()!= square_root && event.getSource() != "." ) {
            if(equals_count == 1){
               text_field.setText("");
               equals_count = 0;
            }
             text_field.setText(text_field.getText() + value);
        }

        //taking only operands!
        else if(event.getSource() == add){
             num1 = Double.parseDouble(text_field.getText()) + num1 ;
             operation = 1;
             text_field.setText("");
             count = 0;
        }
        else if(event.getSource() == sub){
             num1 = Double.parseDouble(text_field.getText())  ;
             operation = 2;
             text_field.setText("");
             count = 0;
        }
        else if(event.getSource() == mul){
             num1 = Double.parseDouble(text_field.getText())  ;
             operation = 3;
             text_field.setText("");
             count = 0;
        }
        else if(event.getSource() == division){
             num1 = Double.parseDouble(text_field.getText())  ;
             operation = 4;
             text_field.setText("");
             count = 0;
        }
        else if(event.getSource() == square_root){
             num1 = Double.parseDouble(text_field.getText());
             num1 = Math.sqrt(num1);
             text_field.setText(String.valueOf(String.format("%.13f",num1)));
             count = 1;
        }
        else if(event.getSource() == equals){
             equals_count = 1;
            double num2 = Double.parseDouble(text_field.getText());
            double check = logic.calculation(num1, num2, operation);
             if(check == -1)
                 text_field.setText("Invalid");
             else
                 text_field.setText(String.valueOf(check));
             num1 = num2 = 0;
             count = 1;
        }
    }
    @FXML
    private void plus_minus(){
        if((text_field.getText().isEmpty()))
          text_field.setText("-");
    }
    @FXML
    private void decimal(){
           if(count == 0){
                text_field.setText(text_field.getText() + ".");
                count = 1;
            }
            else
                text_field.setText(text_field.getText() + "");
    }
    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}*/
}
