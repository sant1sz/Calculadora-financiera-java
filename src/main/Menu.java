package main;

import operaciones.*;
import utils.Validador;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(){
        int option = -1;
        while (option !=0){
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Calculadora básica");
            System.out.println("2. Calcular IVA (19%)");
            System.out.println("3. Calcular descuento");
            System.out.println("4. Calcular presupuesto total");
            System.out.println("0. salir");
            System.out.print("Elige una opción");

            option = Validador.leerEntero(scanner);
            switch (option){
                case 1 -> menuBasica();
                case 2 -> menuIVA();
                case 3 -> menuDescuento();
                case 4 -> menuPresupuesto();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }

        }
    }

    private void menuBasica(){
        System.out.print("Primer numero: ");
        double a = Validador.leerDouble(scanner);
        System.out.print("Operación (+,-,*,/): ");
        String op = scanner.next();
        System.out.print("Segundo numero: ");
        double b = Validador.leerDouble(scanner);

        try{
            double resultado = Calculadora.calcular(a,op,b);
            System.out.printf("resulado: %.2f%n",resultado);
        } catch (ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Operación no reconocida.");
        }

    }

    private void menuIVA(){
        System.out.print("Valor sin IVA (COP): ");
        double valor = Validador.leerDouble(scanner);
        double[] resultado = CalculadoraIVA.calcular(valor);
        System.out.printf("IVA (19%):        $ %,.2f%n",resultado[0]);
        System.out.printf("Total con IVA:   $ %,.2f%n",resultado[1]);

    }

    private void menuDescuento(){
        System.out.print("Precio original (COP): ");
        double precio = Validador.leerDouble(scanner);
        System.out.print("Porcentaje de descuento (%): ");
        double pct = Validador.leerDouble(scanner);
        double[] resultado = CalculadoraDescuento.calcular(precio, pct);
        System.out.printf("Descuento:      $ %,.2f%n", resultado[0]);
        System.out.printf("Precio final:   $ %,.2f%n", resultado[1]);

    }
    private void menuPresupuesto(){
        System.out.print("¿Cuántos items tiene el presupuesto? ");
        int n = Validador.leerEntero(scanner);
        double[] valores = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Item %d (COP): ", i + 1);
            valores[i] = Validador.leerDouble(scanner);
        }
        System.out.print("¿Aplicar IVA al total? (s/n): ");
        boolean conIVA = scanner.next().equalsIgnoreCase("s");
        double total = CalculadoraPresupuesto.calcularTotal(valores, conIVA);
        System.out.printf("Total presupuesto: $ %,.2f%n", total);
    }

}
