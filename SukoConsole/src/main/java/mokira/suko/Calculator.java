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
import java.util.function.BiFunction;
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
  private Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> exprMap;
  private List<String> variableNames;
  private Context ctx;
  private Pipeline<String, Expression> analyser;

  public Calculator() {
    operators = new HashMap();
    exprMap = new HashMap<>();
    variableNames = new ArrayList<>();
    operators.put("+", 1);
    operators.put("-", 1);
    operators.put("/", 2);
    operators.put("*", 2);
    operators.put("(", 0);
    
    exprMap.put("+", (l, r) -> new AddExpression(l, r));
    exprMap.put("-", (l, r) -> new SubtractExpression(l, r));
    exprMap.put("*", (l, r) -> new MultiplyExpression(l, r));
    exprMap.put("/", (l, r) -> new DivisionExpression(l, r));

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
  
  public void addVariableName(String name) {
    this.variableNames.add(name);
  }
  
  public void initAnalyser() {
    // on initialise l'analyseur
    this.analyser = new Pipeline<>(new Preprocess(operators))
            .addHandler(new TreeBuilder(exprMap, variableNames));
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
}
