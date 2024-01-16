/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

import mokira.suko.calc.interpreter.SubtractExpression;
import mokira.suko.calc.interpreter.NonTerminalExpression;
import mokira.suko.calc.interpreter.MultiplyExpression;
import mokira.suko.calc.interpreter.Expression;
import mokira.suko.calc.interpreter.DivisionExpression;
import mokira.suko.calc.interpreter.AddExpression;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import mokira.suko.calc.analyser.Pipeline;
import mokira.suko.calc.analyser.Preprocess;
import mokira.suko.calc.analyser.TreeBuilder;

/**
 *
 * @author mokira3d48
 */
public class CalculatorBuilder implements Builder<Calculator> {
  private Calculator calculator;
  private Map<String, Integer> operators;
  private Map<String, BiFunction<Expression, Expression, NonTerminalExpression>> expressions;

  public CalculatorBuilder() {
    this.reset();
  }

  @Override
  public Calculator getResult() {
    return this.calculator;
  }

  @Override
  public void reset() {
    this.calculator = new Calculator();
  }

  @Override
  public void setOperators() {
    this.operators = new HashMap();
    operators.put("+", 1);
    operators.put("-", 1);
    operators.put("/", 2);
    operators.put("*", 2);
    operators.put("(", 0);
  }

  @Override
  public void setNonTerminalExpressions() {
    expressions = new HashMap<>();
    expressions.put("+", (l, r) -> new AddExpression(l, r));
    expressions.put("-", (l, r) -> new SubtractExpression(l, r));
    expressions.put("*", (l, r) -> new MultiplyExpression(l, r));
    expressions.put("/", (l, r) -> new DivisionExpression(l, r));
  }

  @Override
  public void setAnalyser() {
    var pipelineAnalyser = new Pipeline<>(new Preprocess(this.operators))
            .addHandler(new TreeBuilder(this.expressions));
    this.calculator.setAnalyser(pipelineAnalyser);
  }

}
