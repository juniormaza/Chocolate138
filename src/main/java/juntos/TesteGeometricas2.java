package juntos;

import java.util.Scanner;

public class TesteGeometricas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha a forma geométrica para calcular a área:");
            System.out.println("1. Quadrado");
            System.out.println("2. Retângulo");
            System.out.println("3. Triângulo");
            System.out.println("4. Círculo");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o lado do quadrado: ");
                    double ladoQuadrado = scanner.nextDouble();
                    double areaQuadrado = Geometricas2.calcularAreaQuadrado(ladoQuadrado);
                    System.out.println("A área do quadrado é: " + areaQuadrado);
                    break;
                case 2:
                    System.out.print("Informe a base do retângulo: ");
                    double baseRetangulo = scanner.nextDouble();
                    System.out.print("Informe a altura do retângulo: ");
                    double alturaRetangulo = scanner.nextDouble();
                    double areaRetangulo = Geometricas2.calcularAreaRetangulo(baseRetangulo, alturaRetangulo);
                    System.out.println("A área do retângulo é: " + areaRetangulo);
                    break;
                case 3:
                    System.out.print("Informe a base do triângulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.print("Informe a altura do triângulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    double areaTriangulo = Geometricas2.calcularAreaTriangulo(baseTriangulo, alturaTriangulo);
                    System.out.println("A área do triângulo é: " + areaTriangulo);
                    break;
                case 4:
                    System.out.print("Informe o raio do círculo: ");
                    double raioCirculo = scanner.nextDouble();
                    double areaCirculo = Geometricas2.calcularAreaCirculo(raioCirculo);
                    System.out.println("A área do círculo é: " + String.format("%.2f", areaCirculo).replace(',', '.'));
                    ;
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 5);
    }
}

