/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

import mokira.suko.maths.MathObject;
import mokira.suko.maths.ScalarInt;

/**
 *
 * @author mokira3d48
 */
public class ScalarIntAnalyser extends NumericAnalyser<Integer> {

  /**
   * Default Constructor that define the pattern matching.
   */
  public ScalarIntAnalyser() {
    this.patternString = "[0-9]+";
  }

  /**
   *
   * @param str
   * @return
   */
  @Override
  public MathObject parse(String str) {
    return new ScalarInt(Integer.valueOf(str));
  }
}
