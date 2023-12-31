package mokira.suko;

import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import mokira.suko.compiler.base.Compiler;
import mokira.suko.compiler.DefaultCompiler;
import mokira.suko.compiler.LexicalError;
import mokira.suko.compiler.base.Context;


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
    Pattern[] patterns = new Pattern[3];
    patterns[0] = Pattern.compile("[0-9]");
    patterns[1] = Pattern.compile("\\+");
    patterns[2] = Pattern.compile("-");
    var defaultCompiler = DefaultCompiler.get(patterns);
    
    String[] tokens = new String[0];

    try{
      Context context = new Context();
      tokens = defaultCompiler.execute("23-3+2+12s", context);
    } catch(LexicalError e) {
      System.err.println(e.getMessage());
    } catch(Exception e) {
      System.out.println("ERROR: " + e);
    }

    for (String token: tokens)
      System.out.print(token + " ");

    System.out.println(tokens.length);

    launch();
	}

}