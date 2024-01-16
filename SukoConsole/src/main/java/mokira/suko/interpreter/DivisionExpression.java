/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.interpreter;

import mokira.suko.Context;

/**
 *
 * @author mokira3d48
 */
public class DivisionExpression extends NonTerminalExpression {

  public DivisionExpression() {

  }

  public DivisionExpression(Expression l, Expression r) {
    super(l, r);
  }

  @Override
  public double evaluate(Context c) throws Exception {
    double term1 = getLeftNode().evaluate(c);
    double term2 = getRightNode().evaluate(c);
    
    if (term2 == 0.0)
      throw new SemanticError("{" + term1 + " / 0} --> Division by zero detected.");

    return term1 / term2;
  }
}