package programutvikling.datakomponentregister;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import programutvikling.HelpClass.Dialogs;

public class RegistrerCPU {

    private GridPane guiData;

    public RegistrerCPU(GridPane guiData) {
        this.guiData = guiData;
    }

    public CPU createCPUfromGUIandResetFields() {
        try {
            CPU p = createCPU();
            resetFields();
            Dialogs.showSuccessDialog(p.getCpu());
            return p;
        } catch (NumberFormatException nfe) {
            Dialogs.showErrorDialog("Tast inn heltall for alder og fødselsdato");
        } catch (IllegalArgumentException iae) {
            Dialogs.showErrorDialog(iae.getMessage());
        }
        return null;
    }

    private CPU createCPU() {
        String CPU = getString((TextField) guiData.lookup("#txtCPU"));
        int Klokkehastighet = getInt((TextField) guiData.lookup("#txtKlokkehastighet"));
        int Kjerner = getInt((TextField) guiData.lookup("#txtKjerner"));
        int RAM = getInt((TextField) guiData.lookup("#txtRAM"));
        int pris = getInt((TextField) guiData.lookup("#txtPris"));

        return new CPU(CPU, Klokkehastighet, Kjerner, RAM, pris);
    }

    private String getString(TextField field) {
        return field.getText();
    }

    private int getInt(TextField field) {
        return Integer.parseInt(getString(field));
    }

    private void resetFields() {
        ((TextField) guiData.lookup("#txtCPU")).setText("");
        ((TextField) guiData.lookup("#txtKlokkehastighet")).setText("");
        ((TextField) guiData.lookup("#txtKjerner")).setText("");
        ((TextField) guiData.lookup("#txtRAM")).setText("");
        ((TextField) guiData.lookup("#txtPris")).setText("");
    }

}
