package br.com.iterasys;

import juntos.Geometricas2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Geometricas2Test {

    @Test
    public void testeDoQuadrado(){
        // Cinfigura
        double area = 5;
        double resultadoEsperado = 25;
        // Executa
        double resultadoAtual = Geometricas2.calcularAreaQuadrado(area);
        // Valida
        Assert.assertEquals(resultadoAtual,resultadoEsperado);

    }

    @Test
    public void testeDoRetangulo(){
        // Configura
        double base = 5;
        double altura = 5;
        double resultadoEsperado = 25;
        // Executa
        double resultadoAtual = Geometricas2.calcularAreaRetangulo(base, altura);
        // Valida
        Assert.assertEquals(resultadoAtual,resultadoEsperado);

    }
    @Test
    public void testeDoTriangulo(){
        // Configura
        double base = 5;
        double altura = 5;
        double resultadoEsperado = 12.5;
        // Executa
        double resultadoAtual = Geometricas2.calcularAreaTriangulo(base, altura);
        // Valida
        Assert.assertEquals(resultadoAtual,resultadoEsperado);

    }

    @Test
    public void testeDoCirculo(){
        // Configura
        double area = 5;
        double resultadoEsperado = 78.53981633974483;
        // Executa
        double resultadoAtual = Geometricas2.calcularAreaCirculo(area);
        // Valida
        Assert.assertEquals(resultadoAtual,resultadoEsperado);

    }

}
