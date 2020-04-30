package programutvikling.datakomponentregister;

public class validator {

    static boolean cpu(String cpu){
        return !cpu.isBlank()&&cpu.matches("^[a-zA-Z0-9]");
    }

    static boolean core(String core){
        return !core.isBlank()&&core.matches("^[a-zA-Z0-9]");
    }

    static boolean pris(int pris){
        return pris > 0;

    }

    static boolean clockSpeed(int clockspeed){
        return clockspeed > 0;
    }

    static boolean RAM(String RAM){
        return !RAM.isBlank() && RAM.matches("^[a-zA-Z0-9]");
    }
}