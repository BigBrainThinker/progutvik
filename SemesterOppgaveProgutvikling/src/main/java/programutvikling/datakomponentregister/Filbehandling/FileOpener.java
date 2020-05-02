package programutvikling.datakomponentregister.Filbehandling;

import programutvikling.datakomponentregister.CPURegister;

import java.io.IOException;
import java.nio.file.Path;

public interface FileOpener {

    void open(CPURegister personRegister, Path filePath) throws IOException;

}