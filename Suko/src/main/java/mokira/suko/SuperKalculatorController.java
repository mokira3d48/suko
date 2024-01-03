/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author mokira3d48
 */
public class SuperKalculatorController {
  @FXML
  private Label outputLabel;
  
  @FXML
  private Label inputLabel;
  
  private boolean pressedBinaryOperator;
  private boolean pressedEqual;
  private boolean pressedUnary;
  private boolean storedNum1;
  private boolean storedNum2;
  
  private double num1;
  private double num2;
  
  private String binaryOperator;
  
  private boolean shouldReplaceZero(String outputLabelText) {
    /**
     * replace 0 when we are about to enter value for num2
     * replace 0 after pressing equal
     * replace 0 after pressing unary operation button
     * replace 0 if the current value is 0
     */
    return (storedNum1 && pressedBinaryOperator && !storedNum2)
            || pressedEqual
            || pressedUnary
            || Double.parseDouble(outputLabelText) == 0;
  }
  
  private boolean shouldStoreNum2() {
    // store num2 after storing num1 and pressing a binary operator
    return !storedNum1 && !storedNum2 && pressedBinaryOperator;
  }

  public void handleNumberButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String numberInput = button.getText();
    String outputLabelText = outputLabel.getText();
    
    if (shouldReplaceZero(outputLabelText)) {
      outputLabel.setText(numberInput);
      
      if (shouldStoreNum2())
        storedNum2 = true;

    } else {
      // add to the output label string
      outputLabel.setText(outputLabelText + numberInput);
    }
  }
  
  private void updateBinaryOperator(String binaryOperator) {
    this.binaryOperator = binaryOperator;
    // update calculation sequence
    inputLabel.setText(num1 + " " + binaryOperator);
  }
  
  public void handleBinaryButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String binaryOperator = button.getText();
    
    // store number 1
    if (!storedNum1) {
      num1 = Double.parseDouble(outputLabel.getText());
      storedNum1 = true;
    }
    
    // update binary operation
    if (storedNum1)
      updateBinaryOperator(binaryOperator);
    
    pressedBinaryOperator = true;
    pressedUnary = false;
    pressedEqual = false;

    // perform binary calculation
  }
  
  private void reset() {
    outputLabel.setText("0");
    inputLabel.setText("");
    storedNum1 = false;
    storedNum2 = false;
    pressedBinaryOperator = false;
    pressedEqual = false;
    pressedUnary = false;
  }
  
  public void handleOptionButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String optionName = button.getText();
    
    switch (optionName) {
      case CommonConstants.CLEAR_ENTRY_BTN:
        outputLabel.setText("0");
        break;
      case CommonConstants.CLEAR_BTN:
        reset();
        break;
      case CommonConstants.DEL_BTN:
        if (Double.parseDouble(outputLabel.getText()) != 0) {
          outputLabel.setText(outputLabel.getText().substring(0, outputLabel.getText().length() - 1));
        }
        
        if (outputLabel.getText().length() <= 0) {
          outputLabel.setText("0");
        }
        break;
    }
  }
  
  public void handleCalculationButtonClick(ActionEvent event) {
    outputLabel.setText("COMING SOON!");
  }
}
