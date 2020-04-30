package programutvikling.datakomponentregister;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class CPU implements Serializable {
    private transient SimpleStringProperty cpu;
    private transient SimpleIntegerProperty core;
    private transient SimpleIntegerProperty clockSpeed;
    private transient SimpleIntegerProperty RAM;
    private transient SimpleIntegerProperty pris;


    public CPU(String cpu, int core, int clockSpeed, int RAM, int pris){
        if(!validator.clockSpeed(clockSpeed)){
            throw new IllegalArgumentException("Ugyldig clockspeed, gi ny input");
        }

        if(!validator.pris(core)){
            throw new IllegalArgumentException("Udylig core, gi ny input");
        }

        if(!validator.cpu(cpu)){
            throw new IllegalArgumentException("Ugyldig cpu, gi ny input");
        }
        if(!validator.pris(RAM)){
            throw new IllegalArgumentException("Ugydlig RAM, gi ny input");
        }
        if(!validator.pris(pris)){
            throw new IllegalArgumentException("Pris må være større enn null, gi ny input");
        }

        this.cpu = new SimpleStringProperty(cpu);
        this.core = new SimpleIntegerProperty(core);
        this.clockSpeed = new SimpleIntegerProperty(clockSpeed);
        this.RAM = new SimpleIntegerProperty(RAM);
        this.pris = new SimpleIntegerProperty(pris);
    }


    public String getCpu(){
        return cpu.getValue();
    }

    public final void setCpu(String cpu){
        if(!validator.cpu(cpu)){
            throw new IllegalArgumentException("Cpu kan ikke være tom");
        }
    }
    public int getcore(){
        return core.getValue();
    }

    public final void setCore(String core){
        if(!validator.core(core)){
            throw new IllegalArgumentException("core felt kan ikke stå tomt");
        }
    }

    public int getClockSpeed(){
        return clockSpeed.getValue();
    }

    public final void setClockSpeed(int clockSpeed){
        if(!validator.clockSpeed(clockSpeed)){
            throw new IllegalArgumentException("Clockspeed felt kan ikke stå tomt");
        }
    }

    public int getRam(){
        return RAM.getValue();
    }

    public final void setRam(String RAM){
        if(!validator.RAM(RAM)){
            throw new IllegalArgumentException("RAM felt kan ikke stå tomt");
        }
    }

    public int getPris(){
        return pris.getValue();
    }

    public final void setPris(int pris){
        if(!validator.pris(pris)){
            throw new IllegalArgumentException("Pris felt kan ikke stå tomt eller være 0");
        }
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s",
                cpu.getValue(), RAM.getValue(), pris.toString(),
                core.getValue(), clockSpeed.getValue());
    }
}
