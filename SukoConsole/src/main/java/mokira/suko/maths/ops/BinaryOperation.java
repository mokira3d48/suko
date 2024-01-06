/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths.ops;

import mokira.suko.maths.Variable;


/**
 *
 * @author mokira3d48
 */
public abstract class BinaryOperation extends Operation {
  protected Variable var1;
  protected Variable var2;

  public void setVar1(Variable var) {
    this.var1 = var;
  }

  public void setVar2(Variable var) {
    this.var2 = var;
  }
}
