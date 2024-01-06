/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths;

/**
 *
 * @author mokira3d48
 */
public class Variable extends MathObject {
  protected Double value;
  
  protected Variable() {
    this.value = null;
  }

  /**
   *
   * @param value
   */
  protected Variable(Double value) {
    this();
    this.value = value;
  }

  /**
   *
   * @return
   */
  public Double getValue() {
    return this.value;
  }

  /**
   *
   * @param value
   */
  public void setValue(Double value) {
    this.value = value;
  }
}
