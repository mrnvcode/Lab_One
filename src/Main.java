import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrencyConverter.fxml"));
        AnchorPane root = loader.load();
        loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
