package juntos;

import juntos.Geometricas2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GeometricasTest2 {


    @DataProvider (name = "MassaDoRetangulo")
    public Object [][] massaDoRetanguloDD(){
        return new Object[][]{
                { 5,  2, 10 },
                { 2,   2, 4},
                { 3,   9, 27},
                { 3 , 1 , 3}
        };
    }
    @Test (dataProvider = "MassaDoRetangulo")
    public void testeDoRetanguloDD(double area, double altura, double resultadoEsperado ) {
        // Configura

        // Executa
        double resultadoAtual = Geometricas2.calcularAreaRetangulo(area, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001); // Usando uma margem de erro pequena (0.001) para lidar com valores decimais
    }

    @DataProvider (name = "MassaDoTriangulo")
    public Object[][] massaDoTriangulo(){
        return new Object[][]{
                { 5,  2, 5 },
                { 2,   2, 2},
                { 3,   9, 13.5},
                { 3 , 1 , 1.5}
        };

    }

    @Test(dataProvider = "MassaDoTriangulo")
    public void testeDoTrianguloDD(double base, double altura, double resultadoEsperado){


        // Executa
        double resultadoAtual = Geometricas2.calcularAreaTriangulo(base, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
    }

    @DataProvider (name ="MassaDoCirculo")
    public Object[][] massaDoCirculo(){
        return new Object[][]{
                { 5, 78.53981635 },
                { 10, 314.1592654 },
                {  2, 12.566370616 },
                {  1, 3.141592654 }


        };
    }
    @Test (dataProvider = "MassaDoCirculo")
    public void testeDoCirculoDD(double raio, double resultadoEsperado) {


        // Executa
        double resultadoAtual = Geometricas2.calcularAreaCirculo(raio);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
    }

    @Test
    public void testeDoQuadrado() {
        // Configura
        double lado = 5;
        double resultadoEsperado = 25;

        // Executa
        double resultadoAtual = Geometricas2.calcularAreaQuadrado(lado);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001); // Usando uma margem de erro pequena (0.001) para lidar com valores decimais
    }

    @Test
    public void testeDoRetangulo() {
        // Configura
        double base = 5;
        double altura = 5;
        double resultadoEsperado = 25;

        // Executa
        double resultadoAtual = Geometricas2.calcularAreaRetangulo(base, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
    }

    @Test
    public void testeDoTriangulo() {
        // Configura
        double base = 5;
        double altura = 5;
        double resultadoEsperado = 12.5;

        // Executa
        double resultadoAtual = Geometricas2.calcularAreaTriangulo(base, altura);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
    }

    @Test
    public void testeDoCirculo() {
        // Configura
        double raio = 5;
        double resultadoEsperado = 78.53981633974483;

        // Executa
        double resultadoAtual = Geometricas2.calcularAreaCirculo(raio);

        // Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.001);
    }
}

