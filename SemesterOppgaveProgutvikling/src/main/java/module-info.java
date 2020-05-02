module SemesterOppgaveProgutvikling {
    requires javafx.controls;
    requires javafx.fxml;

    opens programutvikling to javafx.fxml;
    opens programutvikling.datakomponentregister to javafx.base;
    opens programutvikling.datakomponentregister.Filbehandling to javafx.fxml;
    opens programutvikling.gui to javafx.fxml;
    opens programutvikling.gui.sluttbruker to javafx.fxml;
    opens programutvikling.gui.superbruker to javafx.fxml;
    exports programutvikling;
}