package programutvikling.HelpClass;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import programutvikling.datakomponentregister.CPU;
import programutvikling.datakomponentregister.CPURegister;
import programutvikling.datakomponentregister.Filbehandling.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utilities.Constants.CPU_LISTE;

public class FileHandler {
    private enum DialogMode {Open, Save}

    //fjern stage unødvndig
    public static void saveFileCPUArray(Stage stage, CPURegister register){
        try {
            FileWriter myWriter = new FileWriter(CPU_LISTE);
            myWriter.write(register.toString());
            myWriter.close();
            Dialogs.showSuccessDialog("Registeret ble lagret!");
        } catch (IOException e) {
            Dialogs.showErrorDialog("Lagring til fil feilet. Grunn: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveFile(Stage stage, CPURegister register) {
        File selectedFile = getFileFromFileChooser(DialogMode.Save, stage);

        if (selectedFile != null) {
            String fileExt = getFileExt(selectedFile);
            FileSaver saver = null;

            switch (fileExt) {
                case ".txt" : saver = new FileSaverTxt(); break;
                case ".jobj" : saver = new FileSaverJobj(); break;
                default : Dialogs.showErrorDialog("Du kan bare lagre til enten txt eller jobj filer.");
            }

            if(saver != null) {
                try {
                    saver.save(register, selectedFile.toPath());
                    Dialogs.showSuccessDialog("Registeret ble lagret!");
                } catch (IOException e) {
                    Dialogs.showErrorDialog("Lagring til fil feilet. Grunn: " + e.getMessage());
                }
            }
        }
    }

    public static void openFile(Stage stage, CPURegister register) {
        File selectedFile = getFileFromFileChooser(DialogMode.Open, stage);

        if (selectedFile != null) {
            String fileExt = getFileExt(selectedFile);
            FileOpener opener = null;

            switch (fileExt) {
                case ".txt" : opener = new FileOpenerTxt(); break;
                case ".jobj" : opener = new FileOpenerJobj(); break;
                default : Dialogs.showErrorDialog("Du kan bare åpne txt eller jobj filer.");
            }

            if(opener != null) {
                try {
                    opener.open(register, selectedFile.toPath());
                } catch (IOException e) {
                    Dialogs.showErrorDialog("Åpning av filen feilet. Grunn: " + e.getMessage());
                }
            }
        }
    }

    private static File getFileFromFileChooser(DialogMode mode, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg fil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Serialized files", "*.jobj"));

        if(mode == DialogMode.Open) {
            return fileChooser.showOpenDialog(stage);
        } else {
            return fileChooser.showSaveDialog(stage);
        }
    }

    private static String getFileExt(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf('.'));
    }

}