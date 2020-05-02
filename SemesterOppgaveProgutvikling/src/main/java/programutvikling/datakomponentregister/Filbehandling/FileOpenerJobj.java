package programutvikling.datakomponentregister.Filbehandling;

import programutvikling.datakomponentregister.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpenerJobj implements FileOpener {
    @Override
    public void open(CPURegister cpuRegister, Path filePath) throws IOException {
        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin))
        {
            CPURegister register = (CPURegister) oin.readObject();
            cpuRegister.removeAll();
            register.getRegister().forEach(cpuRegister::addCPU);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // debug information here
            throw new IOException("Something is wrong with the implementation. See debug information");
        }
    }
}
