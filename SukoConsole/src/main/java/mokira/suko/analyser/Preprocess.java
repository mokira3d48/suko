/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author mokira3d48
 */
public class Preprocess implements Handler<String, String>{
  private Map<String, Integer> operators;

  public Preprocess(Map<String, Integer> ops) {
    this.operators = ops;
  }

  @Override
  public String process(String input) throws Exception {
    Stack s = new Stack(); // Pile d'appel des operations
    String pfExpr = "";
    String tempStr = "";

    String expr = input.trim();
    for (int i = 0; i < expr.length(); i++) {

      // On recupere un caractere a chaque tour de boucle
      String currChar = expr.substring(i, i + 1);
      
      if (currChar.equals(" "))
        // S'il s'agit du blank alors on continu
        continue;

      if (!isOperator(currChar) && (!currChar.equals("(")) && (!currChar.equals(")"))) {
        pfExpr = pfExpr + currChar;
      } else if (currChar.equals("(")) {
        s.push(currChar);
      } else if (currChar.equals(")")) {
        // for ')' pop all stack contents until '('
        tempStr = (String) s.pop();
        while (!tempStr.equals("(")) {
          pfExpr = pfExpr + tempStr;
          tempStr = (String) s.pop();
        }
        tempStr = "";
      } else if (isOperator(currChar)) {
        // if the current character is an operator
        if (!s.isEmpty()) {
          tempStr = (String) s.pop();
          int val1 = operators.get(tempStr);
          int val2 = operators.get(currChar);

          while ((val1 >= val2)) {
            pfExpr = pfExpr + tempStr;
            val1 = -100;
            if (s.isEmpty() == false) {
              tempStr = (String) s.pop();
              val1 = operators.get(tempStr);
            }
          }
          if ((val1 < val2) && (val1 != -100))
            s.push(tempStr);
        }
        s.push(currChar);
      }
    }

    while (!s.isEmpty()) {
      tempStr = (String) s.pop();
      pfExpr = pfExpr + tempStr;
    }
    // System.out.println(pfExpr);
    return pfExpr;
  }

  private boolean isOperator(String str) {
    return !(this.operators
            .keySet()
            .stream()
            .filter(op -> op.equals(str))
            .toList()
            .isEmpty());

  }
}
