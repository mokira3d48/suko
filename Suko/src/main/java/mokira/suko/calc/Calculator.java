/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import mokira.suko.interpreter.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import mokira.suko.analyser.Handler;
import mokira.suko.analyser.Pipeline;
import mokira.suko.analyser.Preprocess;
import mokira.suko.analyser.TreeBuilder;

/**
 *
 * @author mokira3d48
 */
public class Calculator {
  private String expression;
//  private Map<String, Integer> operators;
//  private Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> expressions;
  private Context context;
//  private List<Handler> handlers;
  private Pipeline analyser;

  public Calculator() {
//    operators = new HashMap();
//    expressions = new HashMap<>();
//    handlers = new ArrayList<>();
//    operators.put("+", 1);
//    operators.put("-", 1);
//    operators.put("/", 2);
//    operators.put("*", 2);
//    operators.put("(", 0);
//
//    expressions.put("+", (l, r) -> new AddExpression(l, r));
//    expressions.put("-", (l, r) -> new SubtractExpression(l, r));
//    expressions.put("*", (l, r) -> new MultiplyExpression(l, r));
//    expressions.put("/", (l, r) -> new DivisionExpression(l, r));

  }

//  public Calculator(Map<String, Integer> operators,
//                    Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> exprs) {
//    this.operators = operators;
//    this.expressions = exprs;
//  }

  public void setExpression(String expr) {
    this.expression = expr;
  }

  public void setContext(Context c) {
    this.context = c;
  }

  public String getExpression() {
    return expression;
  }
  
//  public void addHandler(Handler step) {
//    this.handlers.add(step);
//  }
  
//  public void initAnalyser() {
//    if (this.handlers.isEmpty())
//      return;
//
//    var pipline = new Pipeline<>(this.handlers.get(0));
//    for (int i = 1; i < this.handlers.size(); i++)
//      pipline = pipline.addHandler(this.handlers.get(i));
//
//    this.analyser = pipline;
//  }

//  public void initAnalyser() {
//    // on initialise l'analyseur
//    this.analyser = new Pipeline<>(new Preprocess(this.operators))
//            .addHandler(new TreeBuilder(this.expressions, this.variableNames));
//  }
  
  public void setAnalyser(Pipeline analyser) {
    this.analyser = analyser;
  }

  public double evaluate() throws Exception {
    //infix to Postfix
    // String pfExpr = infixToPostFix(expression);

    //build the Binary Tree
    // Expression rootNode = buildTree(pfExpr);
    Expression rootNode = (Expression) this.analyser.execute(expression, context);

    //Evaluate the tree
    return rootNode.evaluate(this.context);
  }
}
