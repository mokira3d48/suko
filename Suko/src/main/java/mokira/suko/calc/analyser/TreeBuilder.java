/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import mokira.suko.calc.Context;
import mokira.suko.calc.interpreter.Node;
import mokira.suko.calc.interpreter.NonTerminalNode;
import mokira.suko.calc.interpreter.TerminalNode;

/**
 *
 * @author mokira3d48
 */
public class TreeBuilder implements Handler<String, Context, Node> {
  private Map<String, BiFunction<Node, Node, NonTerminalNode>> operators;
  private List<String> variableNames;

  public TreeBuilder(Map<String, BiFunction<Node, Node, NonTerminalNode>> ops) {
    this.operators = ops;
    this.variableNames = new ArrayList<>();
  }
  
  public void setVariableNames(List<String> vars) {
    this.variableNames.clear();
    this.variableNames.addAll(vars);
  }

  @Override
  public Node process(String input, Context context) throws Exception {
    Stack s = new Stack();
    String buffer = "";

    for (int i = 0; i < input.length(); i++) {
      String currChar = input.substring(i, i + 1);

      if (!isOperator(currChar)) {
        // Expression e = new TerminalExpression(currChar);
        // s.push(e);
        buffer += currChar;
      } else {
        Node r = (Node) s.pop();
        Node l = (Node) s.pop();
        Node n = getNonTerminalExpr(currChar, l, r);
        s.push(n);
      }

      if (isVariableName(buffer, context)) {
        Node e = new TerminalNode(buffer);
        s.push(e);
        buffer = "";
      }
    }
    return (Node) s.pop();
  }

  private NonTerminalNode getNonTerminalExpr(String opString, Node l, Node r) {
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
            .collect(Collectors.toList());
      
      if (opFound.isEmpty())
        return null;

      String firstOpStr = opFound.get(0);
      BiFunction<Node, Node, NonTerminalNode> getInstance;
      getInstance = this.operators.get(firstOpStr);
      NonTerminalNode returned = getInstance.apply(l, r);

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
