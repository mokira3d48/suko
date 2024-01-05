/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

import java.util.ArrayList;
import mokira.suko.maths.MathObject;


/**
 *
 * @author mokira3d48
 */
class TokenExpr extends ArrayList<MathObject> {
  private final MathObject[] tokensTab;

  public TokenExpr(MathObject[] tokens) {
    this.tokensTab = tokens;
  }

  @Override
  public String toString() {
    String str = "";
    for (MathObject mathObject: this.tokensTab)
      str += mathObject.toString() + " ";

    return str.substring(0, str.length() - 1);
  }
}
