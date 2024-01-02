/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.atomic_analyser;

import mokira.suko.maths.MathObject;
import mokira.suko.maths.ops.Addition;

/**
 *
 * @author mokira3d48
 */
public class AdditionAnalyser extends OperationAnalyser {
  
  /**
   *
   */
  public AdditionAnalyser() {
    this.patternString = "\\+";
  }

  /**
   *
   * @param str
   * @return
   */
  @Override
  public MathObject parse(String str) {
    return new Addition();
  }
  
}
