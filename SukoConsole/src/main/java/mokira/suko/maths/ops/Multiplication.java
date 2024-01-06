/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths.ops;

import mokira.suko.maths.TermNotDefined;

/**
 *
 * @author mokira3d48
 */
public class Multiplication extends BinaryOperation {

  public Multiplication() {
    super();
    this.tag = "*";
  }

  /**
   *
   * @throws TermNotDefined
   */
  @Override
  public void eval() throws TermNotDefined {
    Double value1 = this.var1.getValue();
    Double value2 = this.var2.getValue();

    if (value1 == null || value2 == null)
      throw new TermNotDefined("Some terms is missing at operation ID: " + this.id);

    Double value3 = value1 * value2;
    this.returned.setValue(value3);
  }
}
