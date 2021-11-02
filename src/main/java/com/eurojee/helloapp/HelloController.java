package com.eurojee.helloapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HelloController {

    @FXML
    TextField loanAmountField;
    @FXML
    TextField interestRateField;
    @FXML
    TextField termLoanField;

    @FXML
    Label totalResultText;

    @FXML
    protected void onHelloButtonClick() {
        //System.out.println("onHelloButtonCLick called!");
        if (!loanAmountField.getText().trim().isEmpty()
                && !interestRateField.getText().trim().isEmpty()
                && !termLoanField.getText().trim().isEmpty()) {

            try {
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText());
                int yearsOfLoan = Integer.parseInt(termLoanField.getText());

                //System.out.println(monthlyRepayments(loanAmount, interestRate, yearsOfLoan));
                totalResultText.setText(monthlyRepayments(loanAmount, interestRate, yearsOfLoan));
            } catch (NumberFormatException e) {

                totalResultText.setText("Only numbers are allowed");
                totalResultText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            }

        } else {
            totalResultText.setText("Missing fields.");
            totalResultText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        }
    }

    @FXML
    protected void resetForm(){
        loanAmountField.setText("");
        interestRateField.setText("");
        termLoanField.setText("");
        totalResultText.setText("\u20ac0 monthly");
        totalResultText.setStyle(null);
    }

    private String monthlyRepayments(double loan, double ratesPercentage, int years){


        int yearsToMonthsConversion = years * 12; // lets convert years into months
        double percentToDecimalConversion = (ratesPercentage / 100) / 12; // convert percentage into decimals

        double loanAmount = loan; // the main amount borrowed
        double interestRate = percentToDecimalConversion;
        int numberOfPayments = yearsToMonthsConversion;

        double topEquation = (Math.pow((1 + interestRate), numberOfPayments)) * interestRate; // top of the equation
        double bottomEquation = (Math.pow((1 + interestRate) , numberOfPayments) - 1); // bottom of the equation
        double totalAmountOfRepayment = (topEquation / bottomEquation) * loanAmount;

        DecimalFormat df = new DecimalFormat("#.00");

        return "\u20ac" + df.format(totalAmountOfRepayment) + " Monthly";
    }


}