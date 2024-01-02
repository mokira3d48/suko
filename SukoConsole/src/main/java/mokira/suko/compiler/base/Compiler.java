/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.base;

/**
 *
 * @author mokira3d48
 * @param <I>
 * @param <C>
 * @param <O>
 */
public class Compiler<I, C, O> extends Pipeline<I, C, O> {

	/**
	 *
   * @param currentStep
	 */
	public Compiler(Handler<I, C, O> currentStep) {
		super(currentStep);
	}
}
