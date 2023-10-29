// Pacote
package br.com.iterasys;
// Bibliotecas
import java.util.Scanner;
// Classe
public class Geometricas{
    //Atributos
    static Scanner sc = new Scanner(System.in);
    public static void calcularQuadrado(){
        double lado;
        lado = 7;
        double areaDoQuadrado = lado * lado;
        System.out.println("A área do quadrado é: " + areaDoQuadrado);


    }

    public static void calcularRetangulo(){
        double base, altura;
        base = 10;
        altura = 3;
        double areaDoRetangulo = base * altura;
        System.out.println("A área do retangulo é: " + areaDoRetangulo);


    }

    public static void calcularTriangulo(){
        double base, altura;
        base = 10;
        altura = 3;
        double areaDoTriangulo = (base * altura) / 2;
        System.out.println("A área do triângulo é: " + areaDoTriangulo);


    }

    public static void calcularCirculo(){
        double circulo;
        circulo = 10;
        double areaDoCirculo = Math.PI * Math.pow(circulo, 2);
        System.out.println("A área do Circulo é: " + areaDoCirculo);
    }


}
