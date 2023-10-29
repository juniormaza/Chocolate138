package juntos;

public class Geometricas2 {
    public static double calcularAreaQuadrado(double lado) {
        return lado * lado;
    }

    public static double calcularAreaRetangulo(double base, double altura) {
        return base * altura;
    }

    public static double calcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double calcularAreaCirculo(double raio) {
        return Math.PI * raio * raio;
    }
}

