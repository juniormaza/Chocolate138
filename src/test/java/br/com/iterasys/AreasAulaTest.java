package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {

    @Test
    public void testarCalcularQuadrado(){
        // Configura
        double lado = 3;
        double resultadoEsperado = 9;

        // Executa
        double resultadoAtual = AreasAula.calcularQuadrado(lado);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }
    @Test
    public void testarCalcularRetangulo() {
        // Configura
        double base = 4;
        double altura = 3;
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = AreasAula.calcularRetangulo(base, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarCalcularTriangulo() {
        // Configura
        double base = 6;
        double altura = 4;
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = AreasAula.calcularTriangulo(base, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarCalcularCirculo() {
        // Configura
        double raio = 5;
        double resultadoEsperado = 78.53981633974483;

        // Executa
        double resultadoAtual = AreasAula.calcularCirculo(raio);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
        // Usando uma margem de erro pequena (0.001) para lidar com valores decimais
    }

}
