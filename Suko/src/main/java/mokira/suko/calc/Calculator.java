/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

import mokira.suko.calc.interpreter.Expression;
import mokira.suko.calc.analyser.Pipeline;


/**
 *
 * @author mokira3d48
 */
public class Calculator {
  private String expression;
  private Context context;
  private Pipeline analyser;


  public void setExpression(String expr) {
    this.expression = expr;
  }

  public void setContext(Context c) {
    this.context = c;
  }

  public String getExpression() {
    return expression;
  }
  
  public void setAnalyser(Pipeline analyser) {
    this.analyser = analyser;
  }

  public double evaluate() throws Exception {
    Expression rootNode = (Expression) this.analyser.execute(expression, context);

    // Evaluate the tree
    return rootNode.evaluate(this.context);
  }
}
