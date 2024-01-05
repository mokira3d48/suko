/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mokira.suko;

import mokira.suko.compiler.DefaultInterpreterBuilder;
import mokira.suko.compiler.analysers.AdditionAnalyser;
import mokira.suko.compiler.analysers.DivisionAnalyser;
import mokira.suko.compiler.analysers.MathObjectAnalyser;
import mokira.suko.compiler.analysers.MultiplicationAnalyser;
import mokira.suko.compiler.analysers.ScalarIntAnalyser;
import mokira.suko.compiler.analysers.SubstractionAnalyser;
import mokira.suko.compiler.exceptions.LexicalError;
import mokira.suko.compiler.Context;
import mokira.suko.compiler.base.Pipeline;
import mokira.suko.maths.MathObject;
import mokira.suko.maths.ops.Addition;
import mokira.suko.maths.ops.Division;
import mokira.suko.maths.ops.Multiplication;
import mokira.suko.maths.ops.Subtraction;


/**
 *
 * @author mokira3d48
 */
public class SukoConsole {

  public static void main(String[] args) {
    MathObjectAnalyser[] patterns = new MathObjectAnalyser[5];
    patterns[0] = new ScalarIntAnalyser();
    patterns[1] = new AdditionAnalyser();
    patterns[2] = new SubstractionAnalyser();
    patterns[3] = new MultiplicationAnalyser();
    patterns[4] = new DivisionAnalyser();
    var defaultCompiler = (Pipeline) DefaultInterpreterBuilder.build(patterns);

    MathObject[] tokens = new MathObject[0];

    try{
      Context context = new Context();
      tokens = (MathObject[]) defaultCompiler.execute("23-3+2+12x8", context);
    } catch(LexicalError e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      e.printStackTrace();
    }

    for (MathObject token: tokens)
      System.out.print(token + " ");

    System.out.println("\nlen = " + tokens.length);
  }
}
