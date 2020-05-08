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

    RegistrerCPU registerCPU = new RegistrerCPU();

    public CPU newCPU;

    @FXML
    void AddCPU(ActionEvent event) {
        newCPU = registerCPU.createCPUfromGUIandResetFields(txtCPU, txtKlokkehastighet, txtKjerner, txtRAM, txtPris);
        cpuControllerSuper.cpuRegister.addCPU(newCPU);
    }

    @FXML
    void Avbryt(ActionEvent event) {
        changePage.closeNewWindow(event);
    }
}
