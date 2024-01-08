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
  
  private String storedExpr = "";
  private boolean hasCalculated = false;

  private boolean shouldReplaceZero(String outputLabelText) {
    return Double.parseDouble(outputLabelText) == 0;
  }

  public void handleNumberButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String numberInput = button.getText();

    if (this.hasCalculated)
      this.reset();
    
    String outputLabelText = outputLabel.getText();

    if (shouldReplaceZero(outputLabelText)) {
      outputLabel.setText(numberInput);
    } else {
      // add to the output label string
      outputLabel.setText(outputLabelText + numberInput);
    }
  }

  public void handleBinaryButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String binaryOperatorString = button.getText() + " ";

    if (this.hasCalculated) {
      storedExpr = "";
      this.hasCalculated = false;
    }

    if (!outputLabel.getText().equals("0")) {
      storedExpr += outputLabel.getText() + " " + binaryOperatorString;
      outputLabel.setText("0");
    } else {
      String tmp = storedExpr.substring(0);
      storedExpr = tmp.substring(0, tmp.length() - 2) + "" + binaryOperatorString;
    }

    inputLabel.setText(storedExpr);
  }

  private void reset() {
    outputLabel.setText("0");
    inputLabel.setText("");
    storedExpr = "";
    this.hasCalculated = false;
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

        this.hasCalculated = false;
        break;
      default:
        break;
    }
  }

  public void handleCalculationButtonClick(ActionEvent event) {
    // outputLabel.setText("COMING SOON!");
    if (this.storedExpr.isEmpty() || this.storedExpr.isBlank())
      // L'expression ne doit pas etre vide ni remplit uniquement d'espace
      return;

    this.storedExpr += outputLabel.getText();
    this.inputLabel.setText(storedExpr);
    this.outputLabel.setText("Buzy...");

    SukoCalculator calculator = new SukoCalculAdapter();
    Double ret = calculator.calculate(this.storedExpr);
    long longValue = ret.longValue();
    this.outputLabel.setText("" + longValue);
    this.hasCalculated = true;
  }
}
