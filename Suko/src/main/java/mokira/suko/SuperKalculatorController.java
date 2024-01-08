/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;


/**
 *
 * @author mokira3d48
 */
public class SuperKalculatorController {
  @FXML
  private Label outputLabel;
  
  @FXML
  private Label inputLabel;
  
  private List<String> storedExpr;
  private boolean hasCalculated = false;
  
  public SuperKalculatorController() {
    storedExpr = new ArrayList<>();
  }
  
  private String joinStringSeq(List<String> strings) {
    String returned = "";
    for (String str: strings)
      returned += str + " ";
    
    return returned.trim();
  }

  private boolean shouldReplaceZero(String outputLabelText) {
    return Double.parseDouble(outputLabelText) == 0;
  }
  
  private void enterNumber(String numberInput) {
    if (this.hasCalculated)
      this.reset();

    String outputLabelText = outputLabel.getText();

    if (shouldReplaceZero(outputLabelText)) {
      outputLabel.setText(numberInput);
    } else {
      // add to the output label string
      outputLabel.setText(outputLabelText + numberInput);
    }
    inputLabel.requestFocus();
  }

  public void handleNumberButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String numberInput = button.getText();
    enterNumber(numberInput);
  }
  
  private void enterOperation(String binaryOperatorString) {
    if (this.hasCalculated) {
      storedExpr.clear();
      this.hasCalculated = false;
    }

    if (!outputLabel.getText().equals("0")) {
      storedExpr.add(outputLabel.getText());
      storedExpr.add(binaryOperatorString);
      outputLabel.setText("0");
    } else {
      if (!storedExpr.isEmpty()) {
//        String tmp = storedExpr.substring(0);
//        storedExpr = tmp.substring(0, tmp.length() - 2) + "" + binaryOperatorString;
        storedExpr.set(storedExpr.size() - 1, binaryOperatorString);
      }
    }

    inputLabel.setText(joinStringSeq(storedExpr));
    inputLabel.requestFocus();
  }

  public void handleBinaryButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String binaryOperatorString = button.getText() + " ";
    enterOperation(binaryOperatorString);
  }

  private void reset() {
    outputLabel.setText("0");
    inputLabel.setText("");
    storedExpr.clear();
    this.hasCalculated = false;
    inputLabel.requestFocus();
  }
  
  private void deleteCharacter() {
    if (this.hasCalculated)
      return;

    if (Double.parseDouble(outputLabel.getText()) != 0) {
      outputLabel.setText(outputLabel.getText().substring(0, outputLabel.getText().length() - 1));
    }
    else {
      if (!storedExpr.isEmpty()) {
        storedExpr.remove(storedExpr.size() - 1);
        inputLabel.setText(joinStringSeq(storedExpr));
        inputLabel.requestFocus();
      }
    }

    if (outputLabel.getText().length() <= 0) {
      outputLabel.setText("0");
    }
  }
  
  private void clearEntry() {
    if (!this.hasCalculated)
      outputLabel.setText("0");
  }

  public void handleOptionButtonClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    String optionName = button.getText();

    switch (optionName) {
      case CommonConstants.CLEAR_ENTRY_BTN:
        clearEntry();
        break;
      case CommonConstants.CLEAR_BTN:
        reset();
        break;
      case CommonConstants.DEL_BTN:
        deleteCharacter();
        break;
      default:
        break;
    }
    
    inputLabel.requestFocus();
  }
  
  @FXML
  public void handleOnKeyPressed(KeyEvent event) {
    // System.out.println("Pressed key text: " + event.getText());
    // System.out.println("Pressed key code: " + event.getCode());

    String keyCode = event.getCode().toString();
    if (keyCode.startsWith("NUMPAD"))
      enterNumber(event.getText());
    else if (keyCode.equals("ADD"))
      enterOperation("+ ");
    else if (keyCode.equals("SUBTRACT"))
      enterOperation("- ");
    else if (keyCode.equals("MULTIPLY"))
      enterOperation("* ");
    else if (keyCode.equals("DIVIDE"))
      enterOperation("/ ");
    else if (keyCode.equals("DELETE"))
      clearEntry();
    else if (keyCode.equals("BACK_SPACE"))
      deleteCharacter();
    else if (keyCode.equals("C"))
      reset();
    else if (keyCode.equals("ENTER"))
      calculate();
  }

  private void calculate() {
    // outputLabel.setText("COMING SOON!");
    if (this.storedExpr.isEmpty())
      // L'expression ne doit pas etre vide ni remplit uniquement d'espace
      return;
    
    storedExpr.add(this.outputLabel.getText());
    String finalExpression = joinStringSeq(storedExpr);
    inputLabel.setText(finalExpression);
    inputLabel.requestFocus();
    this.outputLabel.setText("Buzy...");

    SukoCalculator calculator = new SukoCalculAdapter();
    Double ret = calculator.calculate(finalExpression);
    long longValue = ret.longValue();
    this.outputLabel.setText("" + longValue);
    this.hasCalculated = true;
  }

  public void handleCalculationButtonClick(ActionEvent event) {
    calculate();
  }
}
