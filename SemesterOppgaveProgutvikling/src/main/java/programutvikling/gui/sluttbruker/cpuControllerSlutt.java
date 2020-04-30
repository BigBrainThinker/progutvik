package programutvikling.gui.sluttbruker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import programutvikling.HelpClass.changePage;

import static utilities.Constants.FXML_PATH_SLUTTBRUKER;

public class cpuControllerSlutt {

    @FXML
    private TableColumn<?, ?> CPUColumn;

    @FXML
    private TableColumn<?, ?> coreColumn;

    @FXML
    private TableColumn<?, ?> clockSpeedColumn;

    @FXML
    private TableColumn<?, ?> RAMColumn;

    @FXML
    private TableColumn<?, ?> prisColumn;

    @FXML
    private Label lblAntall;

    @FXML
    private Label lblSUM;

    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private TextField txtSøk;

    @FXML
    private Text txtOversikt;

    @FXML
    void leggTil(ActionEvent event) {

    }

    @FXML
    void slett(ActionEvent event) {

    }

    @FXML
    void tilbake(ActionEvent event) {
        changePage.changePage(FXML_PATH_SLUTTBRUKER + "/mainSlutt.fxml", event);
    }

}
