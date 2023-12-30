/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
class CompilationStep<I, O> implements Handler<I, O> {
	protected Pipeline<I, Boolean> matchingPipeline;   // Pipeline for the building calculus tree
	protected Pipeline<I, O> parsingPipeline;  				 // Pipeline for the matching of the syntaxe

	CompilationStep(Pipeline<I, O> parsing) {
		this.parsingPipeline = parsing;
	}

	CompilationStep(Pipeline<I, Boolean> matching, Pipeline<I, O> parsing) {
		this(parsing);
		this.matchingPipeline = matching;
	}

	/**
	 * Function of processing
	 *
	 * @param I: Represents the input value.
	 * @return O representing the tokens found.
	 */
  @Override
	public O process(I expr) {
		Boolean matched = true;
		if (this.matchingPipeline != null)
			matched = this.matchingPipeline.execute(expr);

		if (!matched)
			return null;

		return this.parsingPipeline.execute(expr);
	}
}

