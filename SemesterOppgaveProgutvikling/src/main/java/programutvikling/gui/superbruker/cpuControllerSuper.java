package programutvikling.gui.superbruker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

import programutvikling.datakomponentregister.*;

public class cpuControllerSuper {

    public GridPane registrationBox;
    public TableView tableView;

    private RegistrerCPU registerCPU;
    private CPURegister cpuRegister = new CPURegister();

    @FXML
    private TextField txtCPU;

    @FXML
    private TextField txtKlokkehastighet;

    @FXML
    private TextField txtKjerner;

    @FXML
    private TextField txtRAM;

    @FXML
    private TextField txtPris;

    @FXML
    public void initialize() {
        registerCPU = new RegistrerCPU(registrationBox);
        updateCPUList();
    }

    private void updateCPUList() {
        CPURegister.attachTableView(tableView);
    }

    @FXML
    void RegistrerCPU(ActionEvent event) {
        CPU newCPU = registerCPU.createCPUfromGUIandResetFields();
        if(newCPU != null) {
            CPURegister.addCPU(newCPU);
        }
    }

    @FXML
    void SlettCPU(ActionEvent event) {

    }

}
