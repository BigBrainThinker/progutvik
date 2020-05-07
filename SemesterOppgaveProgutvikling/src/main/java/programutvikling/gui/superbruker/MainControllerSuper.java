package programutvikling.gui.superbruker;


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

import static utilities.Constants.*;

public class MainControllerSuper {
    private Stage stage;

    @FXML
    private void Find_CPU(ActionEvent event) {
        changePage.changePage(FXML_PATH_SUPERBRUKER + "/cpuSuper.fxml", event);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void tilbakeTilInnlogging(ActionEvent event) {
        changePage.changePage(FXML_PATH_HOME+ "/main.fxml", event);
    }
}
