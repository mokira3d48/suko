/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko;

import java.util.HashMap;

/**
 *
 * @author mokira3d48
 */
public class Context {
  private HashMap varList;

  public void assign(String var, int value) {
    varList.put(var, new Integer(value));
  }

  public int getValue(String var) {
    System.out.println("VAR => " + var);
    Integer objInt = (Integer) varList.get(var);
    return objInt.intValue();
  }

  public Context() {
    this.varList = new HashMap();
    initialize();
  }

  //Values are hardcoded to keep the example simple
  private void initialize() {
    assign("a", 20);
    assign("b", 40);
    assign("c", 30);
    assign("d", 10);
  }
}
