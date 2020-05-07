package programutvikling.datakomponentregister;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import programutvikling.HelpClass.Dialogs;
import javafx.scene.control.TextField;

public class RegistrerCPU {

    public CPU createCPUfromGUIandResetFields(String CPU, String klokkehastighet, String kjerner, String ram, String pris) {
        try {
            CPU p = createCPU(CPU, klokkehastighet,  kjerner, ram , pris);
            //resetFields(CPU, klokkehastighet,  kjerner, ram , pris);
            Dialogs.showSuccessDialog(p.getCpu());
            return p;
        } catch (NumberFormatException nfe) {
            Dialogs.showErrorDialog("Tast inn heltall for alder og fødselsdato");
        } catch (IllegalArgumentException iae) {
            Dialogs.showErrorDialog(iae.getMessage());
        }
        return null;
    }

    private CPU createCPU(String cpuname, String klokkehastighet, String kjerner, String ram, String prisa) {
        String CPU = cpuname;
        int Klokkehastighet = Integer.parseInt(klokkehastighet);
        int Kjerner = Integer.parseInt(kjerner);
        int RAM = Integer.parseInt(ram);
        int pris = Integer.parseInt(prisa);

        return new CPU(CPU, Klokkehastighet, Kjerner, RAM, pris);
    }

    private String getString(TextField field) {
        System.out.println(field.getText());
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
