package com.example.conversor;

public class Moneda {
    private String nombre;
    private String abreviatura;
    private double valor;

    public Moneda(String nombre, String abreviatura, double valor) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.valor = valor;
    }

    public Moneda(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}