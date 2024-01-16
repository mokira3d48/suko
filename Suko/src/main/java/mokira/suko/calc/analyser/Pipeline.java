/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.analyser;

import mokira.suko.analyser.Handler;

/**
 * Generic definition of pipeline class according the Pipeline design pattern
 *
 * @author mokira3d48
 * @param <I>
 * @param <O>
 */
public class Pipeline<I, C, O> {
	protected Handler<I, C, O> currentHandler;

	/**
	 * @param currentHandler: Represents the first handler will be executed in the pipeline.
	 */
	public Pipeline(Handler<I, C, O> currentHandler) {
		this.currentHandler = currentHandler;
	}

	/**
	 * Method will be used to add a new handler instance
	 * into the pipeline instance
	 *
	 * @param <K>
	 * @param newHandler
	 * @return
	 */
	public <K> Pipeline<I, C, K> addHandler(Handler<O, C, K> newHandler) {
		return new Pipeline<>((I inp, C con) -> newHandler.process(currentHandler.process(inp, con), con));
	}

	/**
	 * Method will be used to execute all the handlers
	 * added into the pipeline instance
	 * 
	 * @param input
	 * @return
   * @throws java.lang.Exception
	 */
	public O execute(I input, C context) throws Exception {
		return this.currentHandler.process(input, context);
	}
}
