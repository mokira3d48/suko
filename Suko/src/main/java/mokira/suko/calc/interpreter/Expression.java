/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko.calc.interpreter;

import mokira.suko.calc.Context;

/**
 *
 * @author mokira3d48
 */
public interface Expression {
  public double evaluate(Context c) throws Exception;
}
