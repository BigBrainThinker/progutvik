package programutvikling.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.HelpClass.Dialogs;
import programutvikling.HelpClass.changePage;

import static utilities.Constants.*;

public class LoginControllerSuper {

    @FXML
    private Label lblHeader;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    void CancelLogin(ActionEvent event) {
        changePage.closeNewWindow(event);
    }

    @FXML
    void LoggInSuper(ActionEvent event) {
        String username = "test";
        String password = "1234";

        if(txtUsername.getText().equals(username) && txtPassword.getText().equals(password)) {
            changePage.changePage(FXML_PATH_SUPERBRUKER + "/mainSuperBruker.fxml", event);
        } else {
            Dialogs.showErrorDialog("Feil brukernavn eller password");
        }
    }

}
