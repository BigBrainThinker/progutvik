package programutvikling.HelpClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import programutvikling.datakomponentregister.CPU;
import programutvikling.datakomponentregister.RegistrerCPU;
import programutvikling.gui.LoginControllerSuper;

import java.io.IOException;
import java.net.URL;

import static utilities.Constants.FXML_PATH_HOME;

public class changePage {
    private static CPU newCPU;
    private static  RegistrerCPU registerCPU;

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

    public static void newWindow(String path, ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(
                    LoginControllerSuper.class.getResource(path));
            stage.setScene(new Scene(root));
            stage.setTitle("My modal window");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }

    public static void closeNewWindow(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }


    public static CPU addCpuFrom(String path, ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(
                    LoginControllerSuper.class.getResource(path));
            stage.setScene(new Scene(root));
            stage.setTitle("My modal window");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();
        }
        catch (IOException io){
            io.printStackTrace();
        }
        return newCPU;
    }

}
