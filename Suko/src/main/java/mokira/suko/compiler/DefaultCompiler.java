/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;

import mokira.suko.compiler.base.Handler;
import mokira.suko.compiler.base.Compiler;
import mokira.suko.compiler.base.CompilationStep;
import mokira.suko.compiler.base.Pipeline;


class Step3 implements Handler<String[], String[]> {

	@Override
	public String[] process(String[] tokens) {
		System.out.println("Step3");
		return tokens;
	}
}


class Step4 implements Handler<String[], Float> {

  @Override
	public Float process(String[] tokens) {
		System.out.println("Step4");
		Float number = Float.valueOf(100.0F);
		return number;
	}
}


/**
 *
 * @author mokira3d48
 */
public class DefaultCompiler extends Compiler<String, Float> {
	
	public DefaultCompiler(Handler<String, Float> currentStep) {
		super(currentStep);
	}

	/**
	 *
	 * @return A new instance of the compiler.
	 */
	public static DefaultCompiler get() {
    var lexparsing = new Pipeline<>(new Step3());
		lexparsing.addHandler(new Step4());
		LexicalAnalyser lexical = new LexicalAnalyser(lexparsing);

		String[] tokens = lexical.process("code1");
		for (int i = 0; i < tokens.length; i++)
			System.out.println(tokens[i]);
 
    var synparsing = new Pipeline<>(new Step3());
		synparsing.addHandler(new Step4());
		SyntaxAnalyser syntaxical = new SyntaxAnalyser(synparsing);

  }
}
