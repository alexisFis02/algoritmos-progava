package org.example.princesa;

public class Arista {
    public final int claro;
    public int largo;

    public Arista(int claro, int largo){
        this.claro = claro;
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "[" + claro + "|" + largo + "]";
    }
}
