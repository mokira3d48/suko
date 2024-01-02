/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.lexical.LexicalAnalyser;
import mokira.suko.compiler.lexical.LexicalParsing;
import mokira.suko.compiler.lexical.ExpressionMatcher;
import java.util.regex.Pattern;
import mokira.suko.compiler.atomic_analyser.MathObjectAnalyser;
import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Compiler;


import mokira.suko.compiler.base.Pipeline;
import mokira.suko.maths.MathObject;


/**
 *
 * @author mokira3d48
 */
public class DefaultCompilerBuilder {

	/**
	 *
   * @param patterns
	 * @return A new instance of the compiler.
	 */
	public static Pipeline build(MathObjectAnalyser[] patterns) {
    // Pipeline<String, Context, String[]> compiler = new Pipeline<>(new Preprocess())
    //        .addHandler(new ExpressionMatcher(patterns))
    //        .addHandler(new LexicalParsing(patterns));

    // return compiler;
    Pipeline<String, Context, Boolean> lexMatching = new Pipeline<>(new ExpressionMatcher(patterns));
    Pipeline<String, Context, MathObject[]> lexParsing = new Pipeline<>(new LexicalParsing(patterns));

    LexicalAnalyser lexical = new LexicalAnalyser(lexMatching, lexParsing);

    Pipeline<String, Context, MathObject[]> compiler = new Pipeline<>(new Preprocess())
            .addHandler(lexical);
    return compiler;
  }
}
