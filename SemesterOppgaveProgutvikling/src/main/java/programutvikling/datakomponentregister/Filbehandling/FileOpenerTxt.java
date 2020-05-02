package programutvikling.datakomponentregister.Filbehandling;

import programutvikling.datakomponentregister.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpenerTxt implements FileOpener {
    @Override
    public void open(CPURegister register, Path filePath) throws IOException {
        register.removeAll();
        // try-with-resources lukker automatisk filen
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                register.addCPU(parseCPU(line));
            }
        }
    }

    private CPU parseCPU(String line) throws InvalidCPUFormatException {
        // split line string into three using the separator ";"
        String[] split = line.split(";");
        if(split.length != 5) {
            throw new InvalidCPUFormatException("Du må bruke ; for å separere datafeltene.");
        }

        // extract all datafields from the string
        String cpu = split[0];
        int core = parseNumber(split[1], "Alder må være et tall");
        int clockSpeed = parseNumber(split[2], "Alder må være et tall");
        int RAM = parseNumber(split[3], "Alder må være et tall");
        int pris = parseNumber(split[4], "Alder må være et tall");

        // create new Person object, if data is valid
        try {
            return new CPU(cpu, core, clockSpeed, RAM, pris);
        } catch (IllegalArgumentException e) {
            throw new InvalidCPUFormatException(e.getMessage());
        }
    }

    private int parseNumber(String str, String errorMessage) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }

        return number;
    }
}
