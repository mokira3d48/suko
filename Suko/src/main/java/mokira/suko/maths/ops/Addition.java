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
public class Addition extends Operation {

  public Addition() {
    this.tag = "+";
  }

  /**
   *
   * @throws TermNotDefined
   */
  @Override
  public void perform() throws TermNotDefined {
    if (this.leftNumber == null || this.rightNumber == null)
      throw new TermNotDefined("Some terms is missing at operation ID: " + this.id);
  }
}
