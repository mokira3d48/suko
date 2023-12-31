/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import java.util.regex.Pattern;

import mokira.suko.compiler.base.Handler;
import mokira.suko.compiler.base.Compiler;
import mokira.suko.compiler.base.CompilationStep;
import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Pipeline;


/**
 *
 * @author mokira3d48
 */
public class DefaultCompiler extends Compiler<String, Context, String[]> {
	
  /**
   *
   * @param currentStep
   */
  public DefaultCompiler(Handler<String, Context, String[]> currentStep) {
		super(currentStep);
	}

	/**
	 *
   * @param patterns
	 * @return A new instance of the compiler.
	 */
	public static Compiler<String, Context, String[]> get(Pattern[] patterns) {
    var lexMatching = new Pipeline<>(new ExpressionMatcher(patterns));
    var lexParsing = new Pipeline<>(new LexicalParsing(patterns));
		
		LexicalAnalyser lexical = new LexicalAnalyser(lexMatching, lexParsing);
    
    // Context lexicalContext = new Context();
		// String[] tokens = lexical.process("1+23+3-98", lexicalContext);

//    var synparsing = new Pipeline<>(new Step3());
//		synparsing.addHandler(new Step4());
//		SyntaxAnalyser syntaxical = new SyntaxAnalyser(synparsing);
//    compiler.addHandler();
    return new DefaultCompiler(lexical);
  }
}
