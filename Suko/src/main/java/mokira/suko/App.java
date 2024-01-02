package mokira.suko;

import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import mokira.suko.compiler.DefaultCompilerBuilder;
import mokira.suko.compiler.atomic_analyser.AdditionAnalyser;
import mokira.suko.compiler.atomic_analyser.DivisionAnalyser;
import mokira.suko.compiler.atomic_analyser.MathObjectAnalyser;
import mokira.suko.compiler.atomic_analyser.MultiplicationAnalyser;
import mokira.suko.compiler.atomic_analyser.ScalarIntAnalyser;
import mokira.suko.compiler.atomic_analyser.SubstractionAnalyser;
import mokira.suko.compiler.lexical.LexicalError;
import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Pipeline;
import mokira.suko.maths.MathObject;
import mokira.suko.maths.ops.Addition;
import mokira.suko.maths.ops.Division;
import mokira.suko.maths.ops.Multiplication;
import mokira.suko.maths.ops.Subtraction;


/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		var javaVersion = SystemInfo.javaVersion();
		var javafxVersion = SystemInfo.javafxVersion();

		var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		var scene = new Scene(new StackPane(label), 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
    MathObjectAnalyser[] patterns = new MathObjectAnalyser[5];
    patterns[0] = new ScalarIntAnalyser();
    patterns[1] = new AdditionAnalyser();
    patterns[2] = new SubstractionAnalyser();
    patterns[3] = new MultiplicationAnalyser();
    patterns[4] = new DivisionAnalyser();
    var defaultCompiler = (Pipeline) DefaultCompilerBuilder.build(patterns);

    MathObject[] tokens = new MathObject[0];

    try{
      Context context = new Context();
      tokens = (MathObject[]) defaultCompiler.execute("23-3+2+12x8", context);
    } catch(LexicalError e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      e.printStackTrace();
    }

    for (MathObject token: tokens)
      System.out.print(token + " ");

    System.out.println(tokens.length);

    launch();
	}

}