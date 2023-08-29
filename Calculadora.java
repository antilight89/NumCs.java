public class Calculadora {

    public double somar(double num1, double num2) {
        return num1 + num2;
    }

    public double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Não é possível dividir por zero");
        }
    }

    public double seno(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cosseno(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tangente(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    public double logaritmo(double num) {
        if (num > 0) {
            return Math.log(num);
        } else {
            throw new IllegalArgumentException("Entrada inválida para logaritmo");
        }
    }

    public double raizQuadrada(double num) {
        if (num >= 0) {
            return Math.sqrt(num);
        } else {
            throw new IllegalArgumentException("Entrada inválida para raiz quadrada");
        }
    }

    public double potencia(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
