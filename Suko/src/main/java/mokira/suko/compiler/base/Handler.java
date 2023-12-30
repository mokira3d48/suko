/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko.compiler.base;

/**
 *
 * @author mokira3d48
 */
@FunctionalInterface
public interface Handler<I, O> {

	/**
	 * Process method must be implemented by extension
	 * or by creation of a lambda expression
	 * 
	 * @param input
	 * @return 
	 */
  public O process(I input);
}
