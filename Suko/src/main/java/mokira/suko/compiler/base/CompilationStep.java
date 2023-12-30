/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler.base;


/**
 * Compilation step will be extended or instancies
 * to be used like a step to build the compiler pipeline.
 *
 * @author mokira3d48
 * @param <I>
 * @param <O>
 */
public class CompilationStep<I, O> implements Handler<I, O> {
	protected Pipeline<I, Boolean> matchingPipeline;   // Pipeline for the building calculus tree
	protected Pipeline<I, O> parsingPipeline;  				 // Pipeline for the matching of the syntaxe

	public CompilationStep(Pipeline<I, O> parsing) {
		this.parsingPipeline = parsing;
	}

	public CompilationStep(Pipeline<I, Boolean> matching, Pipeline<I, O> parsing) {
		this(parsing);
		this.matchingPipeline = matching;
	}

	/**
	 * Function of processing
	 *
	 * @param input: Represents the input value.
	 * @return O representing the output value after parsing.
	 */
  @Override
	public O process(I input) {
		Boolean matched = true;
		if (this.matchingPipeline != null)
			matched = this.matchingPipeline.execute(input);

		if (!matched)
			return null;

		return this.parsingPipeline.execute(input);
	}
}

