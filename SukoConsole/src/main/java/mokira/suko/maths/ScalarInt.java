/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths;

/**
 * The scalar of an integer.
 *
 * @author mokira3d48
 */
public class ScalarInt extends Numeric<Integer> {

  public ScalarInt() {
    super();
  }
  
  public ScalarInt(Integer value) {
    super(value);
  }

  @Override
  public String toString() {
    return "" + this.value;
  }
}
