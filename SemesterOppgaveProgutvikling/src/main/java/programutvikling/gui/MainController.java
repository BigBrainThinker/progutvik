package programutvikling.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import programutvikling.HelpClass.changePage;

import static utilities.Constants.FXML_PATH_SLUTTBRUKER;
import static utilities.Constants.FXML_PATH_SUPERBRUKER;

public class MainController {
    public Button sluttBruker;
    private Stage stage;

    @FXML
    void LoggInnSluttBruker(ActionEvent event) {
        changePage.changePage(FXML_PATH_SLUTTBRUKER + "/mainSlutt.fxml", event);
    }

    @FXML
    void LoggInnSuperBruker(ActionEvent event) {
        changePage.changePage(FXML_PATH_SUPERBRUKER + "/cpuSuper.fxml", event);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
