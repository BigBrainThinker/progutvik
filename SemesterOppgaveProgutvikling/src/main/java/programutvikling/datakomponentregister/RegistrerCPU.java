package programutvikling.datakomponentregister;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import programutvikling.HelpClass.Dialogs;
import javafx.scene.control.TextField;

public class RegistrerCPU {

    public CPU createCPUfromGUIandResetFields(TextField CPU, TextField klokkehastighet, TextField kjerner, TextField ram, TextField pris) {
        try {
            CPU p = createCPU(CPU, klokkehastighet,  kjerner, ram , pris);
            resetFields(CPU, klokkehastighet,  kjerner, ram , pris);
            Dialogs.showSuccessDialog(p.getCpu());
            return p;
        } catch (NumberFormatException nfe) {
            Dialogs.showErrorDialog("Tast inn gyldig data");
        } catch (IllegalArgumentException iae) {
            Dialogs.showErrorDialog(iae.getMessage());
        }
        return null;
    }

    private CPU createCPU(TextField cpuname, TextField klokkehastighet, TextField kjerner, TextField ram, TextField prisa) {
        String CPU = getString(cpuname);
        int Klokkehastighet = getInt(klokkehastighet);
        int Kjerner = getInt(kjerner);
        int RAM = getInt(ram);
        int pris = getInt(prisa);

        return new CPU(CPU, Klokkehastighet, Kjerner, RAM, pris);
    }

    private String getString(TextField field) {
        return field.getText();
    }

    private int getInt(TextField field) {
        return Integer.parseInt(getString(field));
    }

    private void resetFields(TextField CPU, TextField klokkehastighet, TextField kjerner, TextField ram, TextField pris) {
        CPU.setText("");
        klokkehastighet.setText("");
        kjerner.setText("");
        ram.setText("");
        pris.setText("");
    }

}
