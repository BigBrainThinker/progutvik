package programutvikling.gui.superbruker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import programutvikling.HelpClass.changePage;
import programutvikling.datakomponentregister.CPU;
import programutvikling.datakomponentregister.RegistrerCPU;

public class cpuLeggTilController {

    @FXML
    private TextField txtCPU;

    @FXML
    private TextField txtKjerner;

    @FXML
    private TextField txtRAM;

    @FXML
    private TextField txtKlokkehastighet;

    @FXML
    private TextField txtPris;

    RegistrerCPU registerCPU;

    public CPU newCPU;

    @FXML
    CPU AddCPU(ActionEvent event) {
        System.out.println(txtCPU.getText());
        newCPU = registerCPU.createCPUfromGUIandResetFields(txtCPU.getText(), txtKlokkehastighet.getText(), txtKjerner.getText(), txtRAM.getText(), txtPris.getText());
        return newCPU;
    }

    @FXML
    void Avbryt(ActionEvent event) {
        changePage.closeNewWindow(event);
    }
}
