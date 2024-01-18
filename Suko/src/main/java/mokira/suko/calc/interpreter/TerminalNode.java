/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc.interpreter;

import mokira.suko.calc.Context;


/**
 *
 * @author mokira3d48
 */
public class TerminalNode implements Node {
  private String var;

  public TerminalNode(String v) {
    this.var = v;
  }

  public double evaluate(Context c) {
    // on recupere juste la valeur de cette variable
    // depuis le context.
    return c.getValue(var);
  }
}