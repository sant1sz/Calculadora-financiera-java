package operaciones;

public class CalculadoraDescuento {
    public static double[] calcular (double precio, double porcentaje){
        double descuento = precio *(porcentaje/100);
        double precioFinal = precio -descuento;
        return new double[]{descuento, precioFinal};
    }
}
