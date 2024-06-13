package com.example.exa_c1_pm;

public class Rectangulo {
    private float base;
    private float altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float calcularArea() {
        return base * altura;
    }

    public float calcularPerimetro() {
        return 2 * (base + altura);
    }
}

