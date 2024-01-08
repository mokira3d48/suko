/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mokira3d48
 */
public class Context {
  private Map<String, Double> varList;

  public void assign(String var, double value) {
    varList.put(var, value);
  }

  public double getValue(String var) {
    // System.out.println(var);
    Double objInt = varList.get(var);
    return objInt.doubleValue();
  }

  public Context() {
    this.varList = new HashMap<>();
    // initialize();
  }

  //Values are hardcoded to keep the example simple
//  private void initialize() {
//    assign("a", 20);
//    assign("b", 40);
//    assign("c", 30);
//    assign("d", 10);
//  }
  
  @Override
  public String toString() {
    String str = "";
    for (String varName: varList.keySet())
      str += varName + " = " + varList.get(varName) + ";\n";

    return str;
  }
}
