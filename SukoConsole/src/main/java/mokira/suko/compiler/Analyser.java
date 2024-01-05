/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.Handler;
import mokira.suko.compiler.base.Pipeline;


/**
 *
 * @author mokira3d48
 * @param <I>
 * @param <O>
 */
public abstract class Analyser<I, O> extends Pipeline<I, Context, O> implements Handler<I, Context, O> {

  /**
   *
   * @param currentHandler
   */
  public Analyser(Handler<I, Context, O> currentHandler) {
    super(currentHandler);
  }
}
