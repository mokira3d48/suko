/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.interpreter;

import mokira.suko.Context;
import mokira.suko.interpreter.NonTerminalExpression;
import mokira.suko.interpreter.Expression;

/**
 *
 * @author mokira3d48
 */
public class SubtractExpression extends NonTerminalExpression {
  
  public SubtractExpression() {

  }
 
  public SubtractExpression(Expression l, Expression r) {
    super(l, r);
  }

  @Override
  public double evaluate(Context c) throws Exception {
    return getLeftNode().evaluate(c) - getRightNode().evaluate(c);
  }
}