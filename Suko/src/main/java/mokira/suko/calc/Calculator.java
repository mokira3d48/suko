/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

import mokira.suko.calc.interpreter.Node;
import mokira.suko.calc.analyser.Pipeline;


/**
 *
 * @author mokira3d48
 */
public class Calculator {
  private String equation;
  private Context context;
  private Pipeline analyser;


  public void setEquation(String expr) {
    this.equation = expr;
  }

  public void setContext(Context c) {
    this.context = c;
  }

  public String getEquation() {
    return this.equation;
  }
  
  public void setAnalyser(Pipeline analyser) {
    this.analyser = analyser;
  }

  public double evaluate() throws Exception {
    Node rootNode = (Node) this.analyser.execute(equation, context);

    // Evaluate the tree
    return rootNode.evaluate(this.context);
  }
}
