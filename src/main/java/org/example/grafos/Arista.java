package org.example.grafos;

public class Arista {
    int destino;
    int distancia;

    public Arista(int destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}
