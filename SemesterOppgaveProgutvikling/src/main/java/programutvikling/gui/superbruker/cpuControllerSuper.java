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
    TextField txtCPU;
    @FXML
    GridPane registrationBox;

    @FXML
    TableView<CPU> tableView;

    RegistrerCPU registerCPU;
    CPURegister cpuRegister = new CPURegister();

    @FXML
    TextField txtKlokkehastighet;

    @FXML
    TextField txtKjerner;

    @FXML
    TextField txtRAM;

    @FXML
    TextField txtPris;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // registerCPU = new RegistrerCPU(registrationBox);
        updateCPUList();
    }

    private void updateCPUList() {
        cpuRegister.attachTableView(tableView);
    }

    @FXML
    private void RegistrerCPU(ActionEvent event){
        CPU newCPU = changePage.addCpuFrom(FXML_PATH_SUPERBRUKER + "/cpuLeggTil.fxml", event);
        if (newCPU != null) {
            cpuRegister.addCPU(newCPU);
            changePage.closeNewWindow(event);
        }
    }

   /* @FXML
    private void RegistrerCPU(ActionEvent event) {
        CPU newCPU = registerCPU.createCPUfromGUIandResetFields();
        if(newCPU != null) {
            cpuRegister.addCPU(newCPU);
        }
    }
    */


    public void slettCpu(ActionEvent actionEvent) {
    }

    public void openFileMenuClicked(ActionEvent actionEvent) {
        FileHandler.openFile(stage, cpuRegister);
        updateCPUList();
    }

    public void saveFileMenuClicked(ActionEvent actionEvent) {
        FileHandler.saveFileCPUArray(stage, cpuRegister);
    }



    public void tilbakeTilInnlogging(ActionEvent event) {
        changePage.changePage(FXML_PATH_HOME + "/main.fxml", event);
    }
}
