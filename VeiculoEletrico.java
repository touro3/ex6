package ex6;
package com.meuapp.veiculoeletrico;

public class VeiculoEletrico {
    private String modelo;
    private String marca;
    private int autonomia;
    private int velocidadeMaxima;
    private double precoSugerido;

    public VeiculoEletrico() {
    }

    public VeiculoEletrico(String modelo, String marca, int autonomia, int velocidadeMaxima, double precoSugerido) {
        this.modelo = modelo;
        this.marca = marca;
        this.autonomia = autonomia;
        this.velocidadeMaxima = velocidadeMaxima;
        this.precoSugerido = precoSugerido;
    }

    // Getters e setters aqui

    @Override
    public String toString() {
        return "VeiculoEletrico{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", autonomia=" + autonomia +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", precoSugerido=" + precoSugerido +
                '}';
    }
}
