/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc.interpreter;

import mokira.suko.calc.Context;


/**
 *
 * @author mokira3d48
 */
public class SubtractNode extends NonTerminalNode {
 
  public SubtractNode(Node l, Node r) {
    super(l, r);
  }

  @Override
  public double evaluate(Context c) throws Exception {
    return this.leftNode.evaluate(c) - this.rightNode.evaluate(c);
  }
}
