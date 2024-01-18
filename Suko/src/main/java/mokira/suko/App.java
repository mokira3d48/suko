package mokira.suko;

// import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("suko.fxml"));
    primaryStage.setTitle("SuKo - Super Kalculator");
    primaryStage.setScene(new Scene(root, 292, 450));

    // String iconPath = getClass().getResource("../").getPath()
    //        ;
    // primaryStage.getIcons().add(new Image(new File(iconPath).getAbsolutePath()));
    primaryStage.setResizable(false);
    primaryStage.show();
  }

//  static void setRoot(String fxml) throws IOException {
//    scene.setRoot(loadFXML(fxml));
//  }
//
//  private static Parent loadFXML(String fxml) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//    return fxmlLoader.load();
//  }

  public static void main(String[] args) {
    launch();
  }
}