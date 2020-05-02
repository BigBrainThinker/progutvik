package programutvikling.datakomponentregister.Filbehandling;

import java.io.IOException;

public class InvalidCPUFormatException extends IOException {
    InvalidCPUFormatException(String message) {
        super(message);
    }
}