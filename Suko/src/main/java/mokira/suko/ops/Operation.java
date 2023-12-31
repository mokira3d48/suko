/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.ops;

import mokira.suko.Numeric;


/**
 * Basic definition of an operation.
 *
 * @author mokira3d48
 */
public abstract class Operation {
  private static long idCounter = 0x0;
  protected long id;
  protected String name;
  protected Numeric leftNumber;
  protected Numeric rightNumber;
  protected Numeric returned;

  {
    this.id = idCounter; 
    idCounter += 1;
    this.leftNumber = null;
    this.rightNumber = null;
    this.returned = null;
  }

  public String getName() {
    return this.name;
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

  public abstract void perfom() throws Exception;

}
