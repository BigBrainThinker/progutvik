package programutvikling.datakomponentregister.Filbehandling;

import programutvikling.datakomponentregister.CPURegister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaverTxt implements FileSaver {
    @Override
    public void save(CPURegister registry, Path filePath) throws IOException {
        Files.write(filePath, registry.toString().getBytes());
    }

}
