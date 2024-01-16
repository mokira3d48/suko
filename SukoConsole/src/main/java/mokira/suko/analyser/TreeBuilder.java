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
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import mokira.suko.interpreter.AddExpression;
import mokira.suko.Context;
import mokira.suko.interpreter.DivisionExpression;
import mokira.suko.interpreter.Expression;
import mokira.suko.interpreter.MultiplyExpression;
import mokira.suko.interpreter.NonTerminalExpression;
import mokira.suko.interpreter.SubtractExpression;
import mokira.suko.interpreter.TerminalExpression;

/**
 *
 * @author mokira3d48
 */
public class TreeBuilder implements Handler<String, Context, Expression> {
  private Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> operators;
  private List<String> variableNames;

  public TreeBuilder(Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> ops) {
    this.operators = ops;
    this.variableNames = new ArrayList<>();
  }
  
  public void setVariableNames(List<String> vars) {
    this.variableNames.clear();
    this.variableNames.addAll(vars);
  }

  @Override
  public Expression process(String input, Context context) throws Exception {
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

      if (isVariableName(buffer, context)) {
        Expression e = new TerminalExpression(buffer);
        s.push(e);
        buffer = "";
      }
    }
    return (Expression) s.pop();
  }

  private NonTerminalExpression getNonTerminalExpr(String opString, Expression l, Expression r) {
//    if (operation.trim().equals("+")) {
//      return new AddExpression(l, r);
//    }
//    if (operation.trim().equals("-")) {
//      return new SubtractExpression(l, r);
//    }
//    if (operation.trim().equals("*")) {
//      return new MultiplyExpression(l, r);
//    }
//    if (operation.trim().equals("/")) {
//      return new DivisionExpression(l, r);
//    }
//    return null;
      List<String> opFound = this.operators
            .keySet()
            .stream()
            .filter(op -> op.equals(opString))
            .toList();
      
      if (opFound.isEmpty())
        return null;

      String firstOpStr = opFound.get(0);
      BiFunction<Expression, Expression, NonTerminalExpression> getInstance;
      getInstance = this.operators.get(firstOpStr);
      NonTerminalExpression returned = getInstance.apply(l, r);

//      System.out.println(opString + " - " + returned.getClass().getName());
      return returned;
  }

  private boolean isOperator(String str) {
    return !(this.operators
            .keySet()
            .stream()
            .filter(op -> op.equals(str))
            .collect(Collectors.toList())
            .isEmpty());

  }

  private boolean isVariableName(String str, Context context) {
    return !(context
            .getVarNames()
            .stream()
            .filter(varn -> varn.equals(str))
            .collect(Collectors.toList())
            .isEmpty());
  }
}
