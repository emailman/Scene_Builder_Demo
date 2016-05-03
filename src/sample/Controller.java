package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField tfInvestmentAmount;

    @FXML
    TextField tfYears;

    @FXML
    TextField tfRate;

    @FXML
    TextField tfFutureValue;


    @FXML
    void btnCalc() {
        try {
            int years = Integer.parseInt(tfYears.getText());
            double annualInterestRate = Double.parseDouble(tfRate.getText());
            double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
            double monthlyInterestRate = (annualInterestRate / 100) / 12;
            double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
            tfFutureValue.setText(String.format("$%.2f", futureValue));
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Future Value Calculator Error");
            alert.setHeaderText(null);
            alert.setContentText("One or more fields missing or not correct format");
            alert.showAndWait();
        }
    }
}
