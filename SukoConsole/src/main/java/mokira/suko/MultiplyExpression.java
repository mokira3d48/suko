/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

/**
 *
 * @author mokira3d48
 */
public class MultiplyExpression extends NonTerminalExpression {
  
  public MultiplyExpression() {

  }

  public MultiplyExpression(Expression l, Expression r) {
    super(l, r);
  }

  @Override
  public double evaluate(Context c) throws Exception {
    return getLeftNode().evaluate(c) * getRightNode().evaluate(c);
  }

}
