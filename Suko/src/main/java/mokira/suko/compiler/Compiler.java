/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
class Compiler<I,O> extends Pipeline<I, O> {
	Compiler(Handler<I, O> currentHandler) {
		super(currentHandler);
	}
}
