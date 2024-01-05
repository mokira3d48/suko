/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.analysers;

import mokira.suko.compiler.Analyser;
import mokira.suko.compiler.Context;
import mokira.suko.compiler.base.Handler;

/**
 *
 * @author mokira3d48
 */
public class LexicalAnalyser extends Analyser<String, TokenExpr> {

  /**
   *
   * @param currentHandler
   */
  public LexicalAnalyser(Handler<String, Context, TokenExpr> currentHandler) {
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
  public TokenExpr process(String input, Context context) throws Exception {
    return this.execute(input, context);
  }
}
