package chatGPT;

import java.util.Scanner;

public class GeometricasGPT {
    public static void calcularAreaQuadrado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o lado do quadrado: ");
        double ladoQuadrado = scanner.nextDouble();
        double areaQuadrado = ladoQuadrado * ladoQuadrado;
        System.out.println("A área do quadrado é: " + areaQuadrado);
    }

    public static void calcularAreaRetangulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a largura do retângulo: ");
        double larguraRetangulo = scanner.nextDouble();
        System.out.print("Informe o comprimento do retângulo: ");
        double comprimentoRetangulo = scanner.nextDouble();
        double areaRetangulo = larguraRetangulo * comprimentoRetangulo;
        System.out.println("A área do retângulo é: " + areaRetangulo);
    }

    public static void calcularAreaTriangulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a base do triângulo: ");
        double baseTriangulo = scanner.nextDouble();
        System.out.print("Informe a altura do triângulo: ");
        double alturaTriangulo = scanner.nextDouble();
        double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
        System.out.println("A área do triângulo é: " + areaTriangulo);
    }

    public static void calcularAreaCirculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o raio do círculo: ");
        double raioCirculo = scanner.nextDouble();
        double areaCirculo = Math.PI * raioCirculo * raioCirculo;
        System.out.println("A área do círculo é: " + areaCirculo);
    }
}
