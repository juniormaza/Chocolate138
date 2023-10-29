package chatGPT;

import java.util.Scanner;

public class TesteGeometricas {
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
                    GeometricasGPT.calcularAreaQuadrado();
                    break;
                case 2:
                    GeometricasGPT.calcularAreaRetangulo();
                    break;
                case 3:
                    GeometricasGPT.calcularAreaTriangulo();
                    break;
                case 4:
                    GeometricasGPT.calcularAreaCirculo();
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

