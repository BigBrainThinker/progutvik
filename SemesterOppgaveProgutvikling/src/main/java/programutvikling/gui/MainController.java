package programutvikling.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import programutvikling.HelpClass.changePage;

import java.io.IOException;

import static utilities.Constants.*;

public class MainController {
    public Button sluttBruker;
    private Stage stage;

    @FXML
    void LoggInnSluttBruker(ActionEvent event) {
        changePage.changePage(FXML_PATH_SLUTTBRUKER + "/mainSlutt.fxml", event);
    }

    @FXML
    void LoggInnSuperBruker(ActionEvent event) throws IOException {

        changePage.changePage(FXML_PATH_HOME + "/loggInnSuper.fxml", event);
        //changePage.newWindow(FXML_PATH_HOME + "/loggInnSuper.fxml", event); fiks senere

    }

    public void setStage(Stage stage) {

        this.stage = stage;
    }

}
