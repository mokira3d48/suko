/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

/**
 *
 * @author mokira3d48
 */
public class DivisionExpression extends NonTerminalExpression {

  public double evaluate(Context c) {
    return getLeftNode().evaluate(c) / getRightNode().evaluate(c);
  }

  public DivisionExpression(Expression l, Expression r) {
    super(l, r);
  }
}