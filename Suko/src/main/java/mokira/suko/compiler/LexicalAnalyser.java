/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.CompilationStep;
import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Pipeline;


/**
 *
 * @author mokira3d48
 */
public class LexicalAnalyser extends CompilationStep<String,Context, String[]> {

	/**
	 *
	 * @param matching: The matching pipeline instance.
	 * @param parsing: The parsing pipeline instance.
	 */
	public LexicalAnalyser(Pipeline<String, Context, Boolean> matching,
                         Pipeline<String, Context, String[]> parsing) {
		super(matching, parsing);
	}
}
