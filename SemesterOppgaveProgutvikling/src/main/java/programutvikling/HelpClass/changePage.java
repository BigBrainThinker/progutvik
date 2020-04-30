package programutvikling.HelpClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class changePage {
    public static void changePage(String path, ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = changePage.class.getResource(path);
            loader.setLocation(url);

            Parent parent = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.centerOnScreen();
    }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
}
