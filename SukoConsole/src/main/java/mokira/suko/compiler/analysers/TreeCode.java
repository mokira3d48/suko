/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

import mokira.suko.maths.MathObject;

/**
 *
 * @author mokira3d48
 */
class TreeCode {
  protected MathObject[] leafs;

  public TreeCode(MathObject[] leafs) {
    this.leafs = leafs;
  }
  
  public MathObject[] getLeafs() {
    return this.leafs;
  }
}
