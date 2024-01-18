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
import mokira.suko.interpreter.AddNode;
import mokira.suko.Context;
import mokira.suko.interpreter.DivisionNode;
import mokira.suko.interpreter.MultiplyNode;
import mokira.suko.interpreter.NonTerminalNode;
import mokira.suko.interpreter.SubtractNode;
import mokira.suko.interpreter.TerminalNode;
import mokira.suko.interpreter.Node;

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
        // Node e = new TerminalNode(currChar);
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
//      return new AddNode(l, r);
//    }
//    if (operation.trim().equals("-")) {
//      return new SubtractNode(l, r);
//    }
//    if (operation.trim().equals("*")) {
//      return new MultiplyNode(l, r);
//    }
//    if (operation.trim().equals("/")) {
//      return new DivisionNode(l, r);
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
