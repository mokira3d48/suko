/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Handler;

import mokira.suko.maths.MathObject;
import mokira.suko.maths.ScalarInt;

import mokira.suko.maths.ops.Addition;
import mokira.suko.maths.ops.Division;
import mokira.suko.maths.ops.Multiplication;
import mokira.suko.maths.ops.Subtraction;


/**
 *
 * @author mokira3d48
 */
public class StringSeqConversion implements Handler<String[], Context, MathObject[]> {

  @Override
  public MathObject[] process(String[] input, Context context) throws Exception {
    MathObject[] expr = new MathObject[input.length];
//    String currentValue;
//    for (int i = 0; i < input.length; i++) {
//      currentValue = input[i];
//      if (ScalarInt.match(currentValue)) {
//        expr[i] = new ScalarInt(currentValue);
//      }
//      else if(Addition.match(currentValue))
//        expr[i] = new Addition();
//      else if (Subtraction.match(currentValue))
//        expr[i] = new Subtraction();
//      else if (Multiplication.match(currentValue))
//        expr[i] = new Multiplication();
//      else if (Division.match(currentValue))
//        expr[i] = new Division();
//    }

    return expr;
  }
  
}
