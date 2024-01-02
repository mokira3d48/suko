/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko.compiler.base;

/**
 *
 * @author mokira3d48
 * @param <I>
 * @param <C>
 * @param <O>
 */
@FunctionalInterface
public interface Handler<I, C, O> {

	/**
	 * Process method must be implemented by extension
	 * or by creation of a lambda expression
	 * 
	 * @param input
   * @param context
	 * @return 
   * @throws java.lang.Exception 
	 */
  public O process(I input, C context) throws Exception;
}
