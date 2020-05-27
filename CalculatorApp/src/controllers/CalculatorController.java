package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import utilities.EvaluateString;

public class CalculatorController {


    @FXML
    private Label expression;
    @FXML
    private Label result;

    public void onButtonClick(MouseEvent mouseEvent) {
        Button button = (Button)mouseEvent.getSource();
        String buttonValue = button.getText();
        switch (buttonValue){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonValue);
                break;
            case "+":
            case "-":
            case "/":
            case "*":
                insertOperator(buttonValue);
                break;
            case "CLEAR":
                clearExpression();
                break;
            case "=":
                double result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
                break;
            case "ANS":
                inserAnswer(getResult().getText());
                break;
        }
    }

    private void inserAnswer(String answer) {
        result.setText(expression.getText() + answer);
    }

    public Label getExpression() {
        return expression;
    }

    public Label getResult() {
        return result;
    }

    public void setResult(String newResult) {
        this.result.setText(newResult);
    }

    private void clearExpression() {
        expression.setText("");
    }

    private void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    private void insertOperator(String operator){
        expression.setText(expression.getText() + " " +operator + " ");
    }
}
