package operaciones;

public class CalculadoraPresupuesto {
    public static double calcularTotal(double[] items, boolean conIVA){
        double subtotal = 0;
        for (double item : items) subtotal+= item;
        if (conIVA) subtotal += subtotal * 0.19;
        return subtotal;
    }
}
