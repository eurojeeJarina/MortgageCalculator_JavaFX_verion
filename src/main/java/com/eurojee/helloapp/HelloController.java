package com.eurojee.helloapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class HelloController {

    @FXML
    TextField loanAmountField;
    @FXML
    TextField interestRateField;
    @FXML
    TextField termLoanField;

    @FXML
    protected void onHelloButtonClick() {
        //System.out.println("onHelloButtonCLick called!");
        if (!loanAmountField.getText().trim().isEmpty()
                && !interestRateField.getText().trim().isEmpty()
                && !termLoanField.getText().trim().isEmpty()) {
            System.out.println("All fields are not empty");
        } else {

            if (loanAmountField.getText() == null || loanAmountField.getText().trim().isEmpty()) {
             System.out.println("LoanAmountField is Empty!");
            }else if(interestRateField.getText() == null || interestRateField.getText().trim().isEmpty()){
                System.out.println("Interest Rate Field is Empty!");
            }else if(termLoanField.getText() == null || termLoanField.getText().trim().isEmpty()){
                System.out.println("Loan Term Field is Empty!");
            }
        }
    }

    private void validation(){

    }


}