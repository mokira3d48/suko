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
import mokira.suko.AddExpression;
import mokira.suko.DivisionExpression;
import mokira.suko.Expression;
import mokira.suko.MultiplyExpression;
import mokira.suko.NonTerminalExpression;
import mokira.suko.SubtractExpression;
import mokira.suko.TerminalExpression;

/**
 *
 * @author mokira3d48
 */
public class TreeBuilder implements Handler<String, Expression> {
  private Map<String, Integer> operators;
  private List<String> variableNames;

  public TreeBuilder(Map<String, Integer> ops, List<String> vars) {
    this.operators = ops;
    this.variableNames = vars;
    // operators.put("+", 1);
    // operators.put("-", 1);
    // operators.put("/", 2);
    // operators.put("*", 2);
    // operators.put("(", 0);
  }

  @Override
  public Expression process(String input) throws Exception {
    Stack s = new Stack();
    String buffer = "";

    for (int i = 0; i < input.length(); i++) {
      String currChar = input.substring(i, i + 1);

      if (!isOperator(currChar)) {
        // Expression e = new TerminalExpression(currChar);
        // s.push(e);
        buffer += currChar;
      } else {
        Expression r = (Expression) s.pop();
        Expression l = (Expression) s.pop();
        Expression n = getNonTerminalExpr(currChar, l, r);
        s.push(n);
      }

      if (isVariableName(buffer)) {
        Expression e = new TerminalExpression(buffer);
        s.push(e);
        buffer = "";
      }
    }
    return (Expression) s.pop();
  }
  
  private NonTerminalExpression getNonTerminalExpr(String operation, Expression l, Expression r) {
    if (operation.trim().equals("+")) {
      return new AddExpression(l, r);
    }
    if (operation.trim().equals("-")) {
      return new SubtractExpression(l, r);
    }
    if (operation.trim().equals("*")) {
      return new MultiplyExpression(l, r);
    }
    if (operation.trim().equals("/")) {
      return new DivisionExpression(l, r);
    }
    return null;
  }

  private boolean isOperator(String str) {
    return ((str.equals("+")) || (str.equals("-")) || (str.equals("*"))
        || (str.equals("/")));
  }

  private boolean isVariableName(String str) {
    return variableNames.indexOf(str) != -1;
  }
}
