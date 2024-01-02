/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.maths;

/**
 *
 * @author mokira3d48
 * @param <T>
 */
public abstract class Numeric<T> extends MathObject {
  protected T value;
  
  protected Numeric() {
    this.value = null;
  }
  
  protected Numeric(T value) {
    this();
    this.value = value;
  }
  
  public T getValue() {
    return this.value;
  }
}
