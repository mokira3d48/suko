package mokira.suko;

import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import mokira.suko.compiler.DefaultCompilerBuilder;
import mokira.suko.compiler.LexicalError;
import mokira.suko.compiler.base.Context;
import mokira.suko.compiler.base.Pipeline;


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
    Pattern[] patterns = new Pattern[4];
    patterns[0] = Pattern.compile("[0-9]");
    patterns[1] = Pattern.compile("\\+");
    patterns[2] = Pattern.compile("-");
    patterns[3] = Pattern.compile("\\*");
    var defaultCompiler = (Pipeline) DefaultCompilerBuilder.build(patterns);
    
    String[] tokens = new String[0];

    try{
      Context context = new Context();
      tokens = (String[]) defaultCompiler.execute("23-3+2+12x8", context);
    } catch(LexicalError e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      e.printStackTrace();
    }

    for (String token: tokens)
      System.out.print(token + " ");

    System.out.println(tokens.length);

    launch();
	}

}