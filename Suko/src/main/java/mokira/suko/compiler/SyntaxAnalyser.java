/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.CompilationStep;
import mokira.suko.compiler.base.Handler;
import mokira.suko.compiler.base.Pipeline;


/**
 *
 * @author mokira3d48
 */
public class SyntaxAnalyser extends CompilationStep<String[], Float> {

	/**
	 *
	 * @param matching: The matching pipeline.
	 * @param parsing: The parsing pipeline.
	 */
	public SyntaxAnalyser(Pipeline<String[], Boolean> matching, Pipeline<String[], Float> parsing) {
		super(matching, parsing);
	}
}
