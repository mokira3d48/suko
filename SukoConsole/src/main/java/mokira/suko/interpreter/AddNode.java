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
public class AddNode extends NonTerminalNode {

  public AddNode(Node l, Node r) {
    super(l, r);
  }
  
  /**
   *
   * @param c
   * @return
   * @throws Exception
   */
  @Override
  public double evaluate(Context c) throws Exception{
    return this.leftNode.evaluate(c) + this.rightNode.evaluate(c);
  }

}
