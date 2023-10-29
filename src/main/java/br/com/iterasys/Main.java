package br.com.iterasys;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //chamarEncomenda();
        //Calculadora.somarInteiros(5,7);
        //Calculadora.subtrairInteiros(7,5);
        //Calculadora.multiplicarInteiros(7,5);
        //Calculadora.dividirInteiros(7,5);
        Geometricas.calcularQuadrado();
        Geometricas.calcularRetangulo();
        Geometricas.calcularTriangulo();
        Geometricas.calcularCirculo();

    }
    public static void chamarEncomenda(){
        int barras = 30;
        Encomenda.calcularBarrasDeChocolatesPorCaixa(barras);
    }
}