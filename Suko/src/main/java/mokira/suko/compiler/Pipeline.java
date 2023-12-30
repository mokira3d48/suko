/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
class Pipeline<I, O> {
	protected Handler<I, O> currentHandler;

	Pipeline(Handler<I, O> currentHandler) {
		this.currentHandler = currentHandler;
	}

	<K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
		return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
	}

	O execute(I input) {
		return this.currentHandler.process(input);
	}
}

