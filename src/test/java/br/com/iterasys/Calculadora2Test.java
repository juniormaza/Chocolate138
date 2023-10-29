// 1 - Pacote
package br.com.iterasys;
// 2 - Bibliotecas

// 3 - Classe

import juntos.Calculadora2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculadora2Test {
    // 3.1 - Atributos

    // 3.2 - Métodos e Funções
    @Test
    public void testeSomar(){
        // Configura - Arrange
        double num1 = 5;
        double num2 = 7;

        double resultadoEsperado = 12;

        // Execute - Act
       double resultadoAtual = Calculadora2.somar(num1, num2);

        // valida  - Assert

        Assert.assertEquals(resultadoAtual,resultadoEsperado);

    }
}
