/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author mokira3d48
 */
public class Context extends HashMap<String, Double> {
  
  public Context() {
    super();
  }

  public void assign(String var, double value) {
    this.put(var, value);
  }

  public double getValue(String var) {
    // System.out.println(var);
    Double objDouble = this.get(var);
    return objDouble.doubleValue();
  }
  
  public Set<String> getVarNames() {
    return this.keySet();
  }
  
  @Override
  public String toString() {
    String str = "";
    for (String varName: this.getVarNames())
      str += varName + " = " + this.getValue(varName) + ";\n";

    return str;
  }
}
