/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

import mokira.suko.compiler.Analyser;
import mokira.suko.compiler.Context;
import mokira.suko.compiler.base.Handler;
import mokira.suko.maths.Numeric;


/**
 *
 * @author mokira3d48
 */
public class SemanticAnalyser extends Analyser<TreeCode, Numeric> {

  /**
   *
   * @param currentHandler
   */
  public SemanticAnalyser(Handler<TreeCode, Context, Numeric> currentHandler) {
    super(currentHandler);
  }

  /**
   *
   * @param input
   * @param context
   * @return
   * @throws Exception
   */
  @Override
  public Numeric process(TreeCode input, Context context) throws Exception {
    return this.execute(input, context);
  }
}
