/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.ops;

/**
 *
 * @author mokira3d48
 */
public class Multiplication extends Operation {

  public Multiplication() {
    this.name = "*";
  }

  /**
   *
   * @throws TermNotDefined
   */
  @Override
  public void perfom() throws TermNotDefined {
    if (this.leftNumber == null || this.rightNumber == null)
      throw new TermNotDefined("Some terms is missing at operation ID: " + this.id);
  }
  
}
