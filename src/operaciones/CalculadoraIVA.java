package operaciones;

public class CalculadoraIVA {
    private static final double IVA = 0.19;

    public static double[] calcular(double valorBase){
        double iva = valorBase * IVA;
        double total = valorBase + IVA;
        return new double[]{iva, total};

    }
}
