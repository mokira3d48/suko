/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.compiler;


class LexicalAnalyser extends CompilationStep<String, String[]> {
	LexicalAnalyser(Pipeline<String, String[]> parsing) {
		super(parsing);
	}

	LexicalAnalyser(Pipeline<String, Boolean> matching, Pipeline<String, String[]> parsing) {
		super(matching, parsing);
	}
}


class SyntaxAnalyser extends CompilationStep<String[], Float> {
	SyntaxAnalyser(Pipeline<String[], Float> parsing) {
		super(parsing);
	}

	SyntaxAnalyser(Pipeline<String[], Boolean> matching, Pipeline<String[], Float> parsing) {
		super(matching, parsing);
	}
}


class Step1 implements Handler<String, String> {

  @Override
	public String process(String expr) {
		System.out.println("Step1");
		return expr;
	}
}


class Step2 implements Handler<String, String[]> {

  @Override
	public String[] process(String expr) {
		System.out.println("Step2");
		return new String[2];
	}
}


class Step3 implements Handler<String[], String[]> {
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
public class DefaultCompilerImpl extends Compiler<String, Float> {

  public DefaultCompilerImpl(Handler<String, Float> currentHandler) {
    super(null);
    Pipeline<String, String[]> lexparsing = new Pipeline<>(new Step1())
			.addHandler(new Step2());
		LexicalAnalyser lexical = new LexicalAnalyser(lexparsing);

		String[] tokens = lexical.process("code1");
		for (int i = 0; i < tokens.length; i++)
			System.out.println(tokens[i]);
    
    Pipeline<String[], Float> synparsing = new Pipeline<>(new Step3())
			.addHandler(new Step4());
		SyntaxAnalyser syntaxical = new SyntaxAnalyser(synparsing);
    
    Handler<String, String[]> root = input -> lexical.process(input);
    this.currentHandler = root;

  }
}
