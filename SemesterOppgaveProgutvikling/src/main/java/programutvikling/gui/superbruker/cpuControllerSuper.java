package programutvikling.gui.superbruker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import programutvikling.HelpClass.FileHandler;
import programutvikling.HelpClass.changePage;
import programutvikling.datakomponentregister.*;

import static utilities.Constants.*;

public class cpuControllerSuper {

    @FXML
    TableView<CPU> tableView;

    static CPURegister cpuRegister = new CPURegister();

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        updateCPUList();
    }

    private void updateCPUList() {
        cpuRegister.attachTableView(tableView);
    }

    @FXML
    private void RegistrerCPU(ActionEvent event){
        changePage.newWindow(FXML_PATH_SUPERBRUKER + "/cpuLeggTil.fxml", event);
    }

    public void slettCpu(ActionEvent actionEvent) {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
    }

    public void openFileMenuClicked(ActionEvent actionEvent) {
        FileHandler.openFile(stage, cpuRegister);
        updateCPUList();
    }

    public void saveFileMenuClicked(ActionEvent actionEvent) {
        FileHandler.saveFile(stage, cpuRegister);
    }

    public void tilbakeTilInnlogging(ActionEvent event) {
        changePage.changePage(FXML_PATH_HOME + "/main.fxml", event);
    }
}
