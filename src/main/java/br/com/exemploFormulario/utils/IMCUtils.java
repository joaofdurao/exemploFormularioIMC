package br.com.exemploFormulario.utils;

public class IMCUtils {

    public IMCUtils() {
    }

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String determinarNivelIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
