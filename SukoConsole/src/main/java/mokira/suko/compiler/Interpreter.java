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
 * @param <C>
 * @param <O>
 */
public class Interpreter<I, C, O> extends Pipeline<I, C, O> {

	/**
	 *
   * @param currentStep
	 */
	public Interpreter(Handler<I, C, O> currentStep) {
		super(currentStep);
	}
}
