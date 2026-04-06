package operaciones;

public class Calculadora {
    public static double calcular(double a, String operacion, double b){
        return switch (operacion){
            case "+" -> a+b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> {
                if (b==0) throw new ArithmeticException("No se puede dividir entre 0");
                yield a/b;
            }
            default -> throw new IllegalArgumentException("Operación invalída.");


        };
    }
}
