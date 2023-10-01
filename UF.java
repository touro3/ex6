package ex6;

package com.meuapp.uf;

public class UF {
    private String nome;
    private String sigla;
    private String capital;
    private String coordenadas;
    private int populacao;
    private double area;
    private double densidade;
    private String[] tresMaioresCidades;

    public UF() {
    }

    public UF(String nome, String sigla, String capital, String coordenadas, int populacao, double area, double densidade, String[] tresMaioresCidades) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
        this.coordenadas = coordenadas;
        this.populacao = populacao;
        this.area = area;
        this.densidade = densidade;
        this.tresMaioresCidades = tresMaioresCidades;
    }

    // Getters e setters aqui

    @Override
    public String toString() {
        return "UF{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", capital='" + capital + '\'' +
                ", coordenadas='" + coordenadas + '\'' +
                ", populacao=" + populacao +
                ", area=" + area +
                ", densidade=" + densidade +
                ", tresMaioresCidades=" + Arrays.toString(tresMaioresCidades) +
                '}';
    }
}
