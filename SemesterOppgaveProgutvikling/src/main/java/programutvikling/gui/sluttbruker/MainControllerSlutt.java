package programutvikling.gui.sluttbruker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import programutvikling.HelpClass.changePage;

import java.io.IOException;
import java.util.Objects;

import static utilities.Constants.FXML_PATH_SUPERBRUKER;
import static utilities.Constants.FXML_PATH_SLUTTBRUKER;

public class MainControllerSlutt {
    private Stage stage;

    @FXML
    private void Find_CPU(ActionEvent event) {
        changePage.changePage(FXML_PATH_SLUTTBRUKER + "/cpuSlutt.fxml", event);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
