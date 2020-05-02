package programutvikling.datakomponentregister.Filbehandling;

import programutvikling.datakomponentregister.CPURegister;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSaver {

    void save(CPURegister registry, Path filePath) throws IOException;

}
