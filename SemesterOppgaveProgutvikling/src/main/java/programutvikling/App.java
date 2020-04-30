package programutvikling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import programutvikling.gui.MainController;
import programutvikling.gui.sluttbruker.MainControllerSlutt;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main", stage));
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String filnavn, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/programutvikling/fxml/" + filnavn + ".fxml"));
        Parent root = (Parent)fxmlLoader.load();
        MainController controller = (MainController) fxmlLoader.getController();
        controller.setStage(stage);
        return root;
    }

    public static void main(String[] args) {
        launch();
    }
}