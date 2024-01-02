/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths.ops;

import mokira.suko.maths.MathObject;
import mokira.suko.maths.Numeric;


/**
 * Basic definition of an operation.
 *
 * @author mokira3d48
 */
public abstract class Operation extends MathObject {
  protected Numeric leftNumber;
  protected Numeric rightNumber;
  protected Numeric returned;

  {
    this.leftNumber = null;
    this.rightNumber = null;
    this.returned = null;
  }

  public void setLeftNumber(Numeric leftNumber) {
    this.leftNumber = leftNumber;
  }

  public void setRightNumber(Numeric rightNumber) {
    this.rightNumber = rightNumber;
  }

  public Numeric getReturned() {
    return this.returned;
  }

  public abstract void perform() throws Exception;

}
