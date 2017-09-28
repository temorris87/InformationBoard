package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by tysonmorris on 6/18/17.
 */
public class InfoBoard extends Application {

  static Stage primaryStage;

  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Information Board");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();

    this.primaryStage = primaryStage;
  }

  public static Stage getStage() {
    return primaryStage;
  }

  public static void main(String[] args) { launch(args); }

}
