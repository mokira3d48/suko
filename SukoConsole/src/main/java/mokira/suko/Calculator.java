/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import mokira.suko.analyser.Pipeline;
import mokira.suko.analyser.Preprocess;
import mokira.suko.analyser.TreeBuilder;

/**
 *
 * @author mokira3d48
 */
public class Calculator {
  private String expression;
  private Map<String, Integer> operators;
  private List<String> variableNames;
  private Context ctx;
  private Pipeline<String, Expression> analyser;

  public Calculator() {
    operators = new HashMap();
    variableNames = new ArrayList<>();
    operators.put("+", 1);
    operators.put("-", 1);
    operators.put("/", 2);
    operators.put("*", 2);
    operators.put("(", 0);
    
    
    // this.analyser = new Pipeline<>();
  }

  public void setContext(Context c) {
    ctx = c;
  }

  public void setExpression(String expr) {
    expression = expr;
  }

  public String getExpression() {
    return expression;
  }

  public List<String> getVariableNames() {
    return variableNames;
  }
  
  public void initAnalyser() {
    // on initialise l'analyseur
    this.analyser = new Pipeline<>(new Preprocess(operators))
            .addHandler(new TreeBuilder(operators, variableNames));
  }

  public double evaluate() throws Exception {
    //infix to Postfix
    // String pfExpr = infixToPostFix(expression);

    //build the Binary Tree
    // Expression rootNode = buildTree(pfExpr);
    Expression rootNode = this.analyser.execute(expression);

    //Evaluate the tree
    return rootNode.evaluate(ctx);
  }

  private NonTerminalExpression getNonTerminalExpression(String operation, Expression l, Expression r) {
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

  private Expression buildTree(String expr) {
    Stack s = new Stack();
    String buffer = "";

    for (int i = 0; i < expr.length(); i++) {
      String currChar = expr.substring(i, i + 1);

      if (!isOperator(currChar)) {
        // Expression e = new TerminalExpression(currChar);
        // s.push(e);
        buffer += currChar;
      } else {
        Expression r = (Expression) s.pop();
        Expression l = (Expression) s.pop();
        Expression n = getNonTerminalExpression(currChar, l, r);
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

  private String infixToPostFix(String str) {
    Stack s = new Stack(); // Pile d'appel des operations
    String pfExpr = "";
    String tempStr = "";

    String expr = str.trim();
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
    return ((str.equals("+")) || (str.equals("-")) || (str.equals("*"))
        || (str.equals("/")));
  }
  
  private boolean isVariableName(String str) {
    return variableNames.indexOf(str) != -1;
  }
}
