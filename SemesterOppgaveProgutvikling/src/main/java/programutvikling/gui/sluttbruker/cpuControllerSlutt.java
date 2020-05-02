package programutvikling.gui.sluttbruker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import programutvikling.HelpClass.FileHandler;
import programutvikling.HelpClass.changePage;
import programutvikling.datakomponentregister.CPU;
import programutvikling.datakomponentregister.CPURegister;
import programutvikling.datakomponentregister.RegistrerCPU;

import static utilities.Constants.FXML_PATH_SLUTTBRUKER;

public class cpuControllerSlutt {

    public TableView<CPU> tableView;

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

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    CPURegister cpuRegister = new CPURegister();

    @FXML
    public void initialize() {
        FileHandler.openFile(stage, cpuRegister);
        updateCPUList();
    }

    private void updateCPUList() {
        cpuRegister.attachTableView(tableView);
    }

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
