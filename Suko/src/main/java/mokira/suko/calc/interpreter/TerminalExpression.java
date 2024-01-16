/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.calc.interpreter;

import mokira.suko.calc.Context;
import mokira.suko.calc.interpreter.Expression;

/**
 *
 * @author mokira3d48
 */
public class TerminalExpression implements Expression {
  private String var;

  public TerminalExpression(String v) {
    var = v;
  }

  public double evaluate(Context c) {
    return c.getValue(var);
  }
}