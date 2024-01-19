/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

import mokira.suko.calc.interpreter.SubtractNode;
import mokira.suko.calc.interpreter.NonTerminalNode;
import mokira.suko.calc.interpreter.MultiplyNode;
import mokira.suko.calc.interpreter.Node;
import mokira.suko.calc.interpreter.DivisionNode;
import mokira.suko.calc.interpreter.AddNode;
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
  private Map<String, BiFunction<Node, Node, NonTerminalNode>> nodes;

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
  public void setNonTerminalNodes() {
    nodes = new HashMap<>();
    nodes.put("+", (l, r) -> new AddNode(l, r));
    nodes.put("-", (l, r) -> new SubtractNode(l, r));
    nodes.put("*", (l, r) -> new MultiplyNode(l, r));
    nodes.put("/", (l, r) -> new DivisionNode(l, r));
  }

  @Override
  public void setAnalyser() {
    var pipelineAnalyser = new Pipeline<>(new Preprocess(this.operators))
            .addHandler(new TreeBuilder(this.nodes));
    this.calculator.setAnalyser(pipelineAnalyser);
  }

}
