/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.interpreter;

import mokira.suko.interpreter.Expression;

/**
 *
 * @author mokira3d48
 */
public abstract class NonTerminalExpression implements Expression {
  private Expression leftNode;

  private Expression rightNode;
  
  public NonTerminalExpression() {

  }

  public NonTerminalExpression(Expression l, Expression r) {
    setLeftNode(l);
    setRightNode(r);
  }

  public void setLeftNode(Expression node) {
    leftNode = node;
  }

  public void setRightNode(Expression node) {
    rightNode = node;
  }

  public Expression getLeftNode() {
    return leftNode;
  }

  public Expression getRightNode() {
    return rightNode;
  }

}
