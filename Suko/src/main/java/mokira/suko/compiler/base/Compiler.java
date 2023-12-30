/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.base;

/**
 *
 * @author mokira3d48
 * @param <I>
 * @param <O>
 */
public class Compiler<I,O> extends Pipeline<I, O> {

	/**
	 *
	 * @param currentHandler
	 */
	public Compiler(Handler<I, O> currentStep) {
		super(currentStep);
	}
}
